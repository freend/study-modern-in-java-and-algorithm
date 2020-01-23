package com.freend.algorithm.programers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class FixtureList {
    // n : 참가자수, a : 나, b : 경쟁자.
    public int findFixture(int n, int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        Queue<Boolean> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i == a - 1 || i == b - 1);
        }
        return roundRoutine(queue, n / 2, 1);
    }
    private int roundRoutine(Queue<Boolean> queue, int n, int count) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean bolA = queue.poll();
            boolean bolB = queue.poll();
            if (bolA & bolB) result = count;
            queue.add(bolA | bolB);
        }
        result = (result != 0) ? result : roundRoutine(queue, n / 2, count + 1);
        return result;
    }
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while(a != b)
        {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }
}
