package com.groupb.cuiz.support.util.build;

import org.apache.commons.exec.*;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.*;
import java.time.Duration;

public class QuizSourceExecutor {

    /**
     * 하나의 Input에 대해 script명령어를 만들고 실행한다.
     * 실행 후 output을 리턴한다
     * @param path
     * @param filename
     * @param input
     * @return
     * @throws IOException
     */
    public static String runCode(String path, String filename, String input) throws IOException {
        String command = String.format("java -Dfile.encoding=UTF8 -cp %s %s", path, filename);

        return sendCommandToScript(command, input);
    }

    /**
     * 자바 UTF-8 컴파일 명령어 생성 후
     * 생성된 컴파일 명령어로 컴파일 하고 결과를 리턴한다.
     * @param path
     * @return
     */
    public static boolean compileJava(String path) {
        //자바파일을 컴파일
        String command = "javac -encoding UTF-8 " + path;
        try {
            sendCommandToScript(command, null);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 만들어진 명령어와 input으로 줄 데이터를 받아 script를 통해 실행한 결과를 리턴한다
     * @param command
     * @param input
     * @return
     * @throws IOException
     */
    public static String sendCommandToScript(String command, String input) throws IOException {
        //스크립트에 command를 보내고 출력값을 받아온다
        System.out.println("스크립트 실행 : command = " + command);
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

        executor.setExitValues(new int[]{0,1});
        executor.setStreamHandler(streamHandler);
        executor.setWatchdog(watchdog);

        Integer exitVal = null;
        //command 보내기
        try{
            exitVal = executor.execute(commandLine);
        } catch (ExecuteException e){
            os.close();
            System.out.println("e.getMessage() = " + e.getMessage());
            if(watchdog.killedProcess()){
                return "timeout";
            }
            throw e;
        }
        os.close();

        System.out.println("result = " + outputStream.toString("UTF-8"));
        System.out.println("스크립트 종료--------------" + exitVal);
        return outputStream.toString("UTF-8");
    }
}
