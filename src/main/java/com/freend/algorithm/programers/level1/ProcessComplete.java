package com.freend.algorithm.programers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessComplete {
    public int[] completeProcess(int[] progresses, int[] speeds) {
        LinkedList<Integer> successDate = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            double remainDate = (100 - progresses[i]) / (double) speeds[i];
            int endDate = (int) Math.ceil(remainDate);
            successDate.add(Integer.valueOf(String.valueOf(endDate)));
        }
        while (successDate.size() != 0) {
            int indexDate = successDate.poll();
            int completeSum = 1;
            while (successDate.size() != 0 && indexDate >= successDate.peek()) {
                successDate.poll();
                completeSum ++;
            }
            answerList.add(completeSum);
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
