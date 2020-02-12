package com.freend.algorithm.programers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class FoldedThePaper {
    int foldNum = 0;
    public int[] foldPaper(int n) {

        int[] result = {0};
        if (n == 1) {
            return result;
        }
        Queue<Integer> queue;
        Queue<Integer> resultQueue = new LinkedList<>();
        resultQueue.add(0);
        foldNum = 1;
        for (int i = 2; i <= n; i++) {
            queue = resultQueue;
            resultQueue = new LinkedList<>();
            foldNum = 0;
            resultQueue.add(foldNum);
            while (!queue.isEmpty()) {
                resultQueue.add(queue.poll());
                foldNum = (foldNum == 1) ? 0 : 1;
                resultQueue.add(foldNum);
            }
        }
        int len = resultQueue.size();
        result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = resultQueue.poll();
        }
        return result;
    }
}
