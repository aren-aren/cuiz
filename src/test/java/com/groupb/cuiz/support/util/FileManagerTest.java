package com.groupb.cuiz.support.util;

import com.groupb.cuiz.MyTest;
import com.groupb.cuiz.support.util.file.FileManager;
import com.groupb.cuiz.web.quiz.QuizService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FileManagerTest extends MyTest {

    @Autowired
    private FileManager fileManager;
    @Autowired
    private QuizService quizService;

}