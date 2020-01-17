package com.freend.algorithm.programers.level1;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EasyAlgorithmTest {
    EasyAlgorithm easyAlgorithm;
    @Before
    public void setUp() {
        this.easyAlgorithm = new EasyAlgorithm();
    }

    @Test
    public void 행렬_더하기() {
        int[][] arr1 = new int[][]{{1, 2}, {2, 3}};
        int[][] arr2 = new int[][]{{3, 4}, {5, 6}};

        assertThat(this.easyAlgorithm.addMatrix(arr1, arr2), equalTo(new int[][]{{4, 6}, {7, 9}}));
    }

    @Test
    public void 문자의_반복() {
        assertThat(this.easyAlgorithm.repeatCharacter(3), equalTo("수박수"));
        assertThat(this.easyAlgorithm.repeatCharacter(4), equalTo("수박수박"));
    }


    @Test
    public void 그냥해보기() {
        String txt = "Zbcdefg";
        String[] txtArr = txt.split("");
        Arrays.sort(txtArr, Collections.reverseOrder());

        String stringBuffer = Arrays.stream(txtArr).collect(Collectors.joining());
    }

    @Test
    public void 소수의_수량_반환하기() {
        assertThat(this.easyAlgorithm.primeNumber(120), Matchers.equalTo(30));
    }

    @Test
    public void 약수의_합_구하기() {
        int n = 12;
        assertThat(this.easyAlgorithm.sumCommonDivide(n), Matchers.equalTo(28));
    }

    @Test
    public void 김서방을_찾아라() {
        String[] seoul = new String[] {"Jane", "Kim"};
        assertThat(this.easyAlgorithm.findKim(seoul), Matchers.equalTo("김서방은 1에 있다"));
    }

    @Test
    public void x만큼_간격이_있는_n개의_숫자() {
        assertThat(this.easyAlgorithm.intervalArray(2, 5), equalTo(new long[]{2,4,6,8,10}));
        assertThat(this.easyAlgorithm.intervalArray(4, 3), equalTo(new long[]{4,8,12}));
        assertThat(this.easyAlgorithm.intervalArray(-4, 2), equalTo(new long[]{-4, -8}));
    }
    @Test
    public void sample() {
        int horizontalNum = 5;
        int verticalNum = 3;
        String str = "";
        String total = "";
//        long num = (long)Math.pow(10, i);
//        str = String.valueOf(num).replaceAll("0", "*").replace("1", "");
        for (int i = 0; i < horizontalNum; i++) {
            str += "*";
        }
        for (int i = 0; i < verticalNum; i++) {
            total += str + "\n";
        }
        System.out.println(total);
    }

    @Test
    public void 예산분배() {
        assertThat(this.easyAlgorithm.greedyBudget(new int[]{1,3,2,5,4}, 9), equalTo(3));
        assertThat(this.easyAlgorithm.greedyBudget(new int[]{2,2,3,3}, 10), equalTo(4));
    }
}