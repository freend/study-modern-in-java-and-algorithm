package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

public class MathExaminationTest {
    MathExamination mathExamination;
    @Before
    public void setUp() {
        mathExamination = new MathExamination();
    }
    @Test
    public void 수학_테스트() {
        int answerLength = 50;
        int[] answerArray = new int[answerLength];
        for (int i = 0; i < answerLength; i++) {
            answerArray[i] = (int) (Math.random() * 5) + 1;
        }
        System.out.println(mathExamination.solution(new int[]{1,3,2,4,2}));
    }
}