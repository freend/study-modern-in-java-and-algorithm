package com.freend.algorithm.programers;

import java.util.Arrays;

public class ItemMatching {
    public boolean solution(int[] arrays) {
        Arrays.sort(arrays);
        if (arrays[0] == 0) {
            return false;
        } else {
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i] != i + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
