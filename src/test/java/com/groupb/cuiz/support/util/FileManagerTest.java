package com.groupb.cuiz.support.util;

import com.groupb.cuiz.MyTest;
import com.groupb.cuiz.web.quiz.QuizService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FileManagerTest extends MyTest {

    @Autowired
    private FileManager fileManager;
    @Autowired
    private QuizService quizService;
    @Test
    public void fileSaveTest() throws Exception {
        String realPath = "d:/test";
        String filename = "Javatest";
        String extension = ".java";
        String source = "import java.util.Scanner;\npublic class Javatest{\n public static void main(String[] args){\nScanner scan = new Scanner(System.in);\nString str = scan.next();\nwhile(!str.equals(\"3\")){str=\"123\";}  System.out.println(str); \n}\n }";

        fileManager.fileSaveByString(realPath,filename,source,extension);

        boolean compileResult = quizService.compileJava(realPath + "/" + filename + extension);
        if(!compileResult){
            System.out.println("실?패");
            return;
        }

        String command = String.format("java -cp %s %s", realPath, filename);
        String result = quizService.sendCommandToScript(command,"qwerqwer");

        System.out.println("result = " + result);
    }
}