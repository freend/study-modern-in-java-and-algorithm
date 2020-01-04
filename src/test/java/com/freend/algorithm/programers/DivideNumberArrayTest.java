package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

public class DivideNumberArrayTest {
    DivideNumberArray divideNumberArray;
    @Before
    public void setUp() {
        this.divideNumberArray = new DivideNumberArray();
    }

    @Test
    public void 나눠지는_오름차순_배열() {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        int[] answer = this.divideNumberArray.solution(arr, divisor);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        System.out.println("---------------------");
        arr = new int[]{2, 36, 1, 3};
        divisor = 1;
        answer = this.divideNumberArray.solution(arr, divisor);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        System.out.println("---------------------");
        arr = new int[]{3, 2, 6};
        divisor = 10;
        answer = this.divideNumberArray.solution(arr, divisor);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}