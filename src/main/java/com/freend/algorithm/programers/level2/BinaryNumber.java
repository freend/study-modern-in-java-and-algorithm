package com.freend.algorithm.programers.level2;

import java.util.Arrays;

public class BinaryNumber {
    public int getNextNumber(int n) {
        int counter = getCounter(n);
        return getNextNumber(n + 1, counter);
    }
    private int getNextNumber(int targetNum, int counter) {
        int result = (getCounter(targetNum) == counter) ? targetNum : getNextNumber(targetNum + 1, counter);
        return result;
    }
    private int getCounter(int targetNum) {
        String sourceString = Integer.toBinaryString(targetNum);
        String[] arr = sourceString.split("");
        Arrays.sort(arr);
        sourceString = Arrays.toString(arr).replaceAll("[^0-9]","");
        int result = sourceString.length() - sourceString.indexOf("1");
        return result;
    }
}
