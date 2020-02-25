package com.freend.algorithm.programers.level1;

public class ReverseArray {
    public int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");

        return reverseArrayTypeInt(arr);
    }
    private int[] reverseArrayTypeInt(String[] arr) {
        int[] result = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            result[j] = Integer.parseInt(arr[i]);
            j++;
        }

        return result;
    }
}
