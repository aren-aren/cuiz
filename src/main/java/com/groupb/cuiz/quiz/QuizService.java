package com.groupb.cuiz.quiz;

import org.apache.commons.exec.*;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Duration;

@Service
public class QuizService {
    public MemberAnswerDTO runCode(MemberAnswerDTO answer){
        //코드를 파일로 저장후 path, filename 받아옴
        String path = null;
        String filename = null;

        //컴파일
        if(!compileJava(path)){
            answer.setAnswerResult(false);
            answer.setResultMessage("컴파일 에러");
            return answer;
        }
        //DB에서 테스트 케이스를 가져옴
        String[] inputs = null;
        String[] outputs = null;

        TestcaseResultDTO resultDTO = new TestcaseResultDTO();
        for (int i = 0; i < inputs.length; i++) {
            try {
                resultDTO = runCode(path, filename, inputs[i], outputs[i]);
            } catch (IOException e) {
                resultDTO = new TestcaseResultDTO();
                resultDTO.setResult(false);
                resultDTO.setResultMessage("런타임 에러");
            } finally {
                resultDTO.setTestcaseNum(i+1);
                answer.getTestCaseResultDTOS().add(resultDTO);
            }
        }
        return answer;
    }
    private String saveJavaFile(String userCode){
        return null;
    }
    private boolean compileJava(String path) {
        String command = "javac " + path;
        String result = "";
        try {
            result = sendCommendToScript(command, null);
        } catch (IOException e) {
            System.out.println(result);
            return false;
        }
        return true;
    }
    private TestcaseResultDTO runCode(String path, String filename, String input, String output) throws IOException {
        TestcaseResultDTO testcaseResultDTO = new TestcaseResultDTO();
        String command = String.format("java -cp %s %s", path, filename);
        String result = sendCommendToScript(command, input);

        if(result.equals("timeout")){
            testcaseResultDTO.setResult(false);
            testcaseResultDTO.setResultMessage("시간초과");
        } else if(result.equals(output)){
            testcaseResultDTO.setResult(true);
            testcaseResultDTO.setResultMessage("정답입니다.");
        } else {
            testcaseResultDTO.setResult(false);
            testcaseResultDTO.setResultMessage("오답입니다.");
        }

        return testcaseResultDTO;
    }
    private String sendCommendToScript(String command, String input) throws IOException {
        //출력을 받을 outputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //command를 파싱
        CommandLine commandLine = CommandLine.parse(command);

        //Script와 연결해줄 객체
        DefaultExecutor executor = DefaultExecutor.builder().get();

        //input이 있으면 입력함
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        if(input != null) {
            OutputStreamWriter ow = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(ow);

            bw.write(input);
            bw.flush();
        }
        ByteArrayInputStream ins = new ByteArrayInputStream(os.toByteArray());

        //연결후 데이터를 주고 받는 handler
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream, OutputStream.nullOutputStream(), ins);

        //시간 제한
        ExecuteWatchdog watchdog = ExecuteWatchdog.builder().setTimeout(Duration.ofSeconds(10)).get();

        executor.setExitValue(0);
        executor.setStreamHandler(streamHandler);
        executor.setWatchdog(watchdog);

        //command 보내기
        try{
            executor.execute(commandLine);
        } catch (ExecuteException e){
            os.close();
            if(watchdog.killedProcess()){
                return "timeout";
            }
        }
        os.close();

        return outputStream.toString("UTF-8");
    }


}
