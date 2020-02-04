package com.freend.algorithm.programers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleItemMinSum {
    public int minNum(int[] arrFirst, int[] arrSecond) {
        int result = 0;
        List<Integer> listFirst = Arrays.stream(arrFirst).boxed().collect(Collectors.toList());
        List<Integer> listSecond = Arrays.stream(arrSecond).boxed().collect(Collectors.toList());
        listSecond.sort(Collections.reverseOrder());
        for (int i = 0; i < listFirst.size(); i++) {
            result += listFirst.get(i) * listSecond.get(i);
        }
        return result;
    }

    public int numSum(int[] arrFirst, int[] arrSecond) {
        int result = 0;
        Arrays.sort(arrFirst);
        Arrays.sort(arrSecond);
        int len = arrFirst.length;
        for (int i = 0; i < len; i++) {
            result += arrFirst[i] * arrSecond[len - (i + 1)];
        }
        return result;
    }
}
