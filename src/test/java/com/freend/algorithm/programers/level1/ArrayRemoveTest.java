package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

public class ArrayRemoveTest {
    ArrayRemove arrayRemove;
    @Before
    public void setUp() {
        this.arrayRemove = new ArrayRemove();
    }

    @Test
    public void 제일작은_원소를_제거한_배열_반환받기() {
        int[] result = arrayRemove.arrayRemoveMinimumItem(new int[]{5, 1, 2, 6, 8});
        for (int i = 0; i < result.length; i++) {
            System.out.println("result : " + result[i]);
        }
//        System.out.println("---------");
//        int[] resultTwo = arrayRemove.arrayRemoveMinimumItem(new int[]{10});
//        for (int i = 0; i < resultTwo.length; i++) {
//            System.out.println("result : " + resultTwo[i]);
//        }
    }
}