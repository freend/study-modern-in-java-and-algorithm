package com.freend.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideNumberArray {
    int[] arr;
    int divisor;
    List<Integer> list;
    public int[] solution(int[] arr, int divisor) {
        if (divisorZeroChecker(divisor)) {
            System.out.println("divisor zero");
            return returnNoAnswer();
        }

        this.divisor = divisor;
        Arrays.sort(arr);
        this.arr = arr;

        if (arrayMaxNumUnderDivisorChecker()) {
            System.out.println("array max number under divisor");
            return returnNoAnswer();
        }

        itemAddList();

        if (list.isEmpty()) {
            System.out.println("list empty");
            return returnNoAnswer();
        }

        return listToArray();
    }

    private int[] listToArray() {
        int[] answer = new int[this.list.size()];
        for (int i = 0; i < this.list.size(); i++) {
            answer[i] = this.list.get(i);
        }
        return answer;
    }
    private void itemAddList() {
        this.list = new ArrayList<>();
        for (int value : this.arr) {
            if (divideMatcher(value)) {
                list.add(value);
            }
        }
    }

    private boolean divideMatcher(int value) {
        return value % this.divisor == 0;
    }

    private boolean arrayMaxNumUnderDivisorChecker() {
        return this.arr[this.arr.length - 1] < this.divisor;
    }

    private boolean divisorZeroChecker(int divisor) {
        return divisor == 0;
    }

    private int[] returnNoAnswer() {
        return new int[]{-1};
    }
}
