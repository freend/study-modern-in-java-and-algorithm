package com.freend.algorithm.programers.level1;

import java.util.Arrays;

public class Runner {
    public String completionSolution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }
}
