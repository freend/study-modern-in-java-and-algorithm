package com.freend.algorithm.programers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayRemove {
    Queue<Integer> queue;
    int[] answer;
    public int[] arrayRemoveMinimumItem(int[] arr) {
        if (this.isPrefixPredicate(arr)) {
            return new int[] {-1};
        }
        this.answer = new int[arr.length - 1];
        this.queue = new PriorityQueue<>();

        arrayAddQueue(arr);
        queueAddArray(arr);
        return this.answer;
    }

    private void queueAddArray(int[] arr) {
        int minimunNum = this.queue.poll();
        int idx = 0;
        int position = 0;
        while (idx < arr.length - 1) {
            if (arr[position] != minimunNum) {
                this.answer[idx] = arr[position];
                idx ++;
            }
            position ++;
        }
    }

    private void arrayAddQueue(int[] arr) {
        for (int value : arr) {
            this.queue.add(value);
        }
    }

    private boolean isPrefixPredicate(int[] arr) {
        return arr.length < 2;
    }

    private int[] otherAnswer(int[] arr) {
        if (arr.length <= 1) return new int[]{ -1 };
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();
    }
}
