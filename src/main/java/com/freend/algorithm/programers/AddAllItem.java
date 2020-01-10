package com.freend.algorithm.programers;

import java.util.Arrays;
import java.util.Collections;

public class AddAllItem {
    public int solution(int n) {
        int answer = 0;
        String[] strArr = String.valueOf(n).split("");
        Arrays.sort(strArr, Collections.reverseOrder());
        boolean findZero = false;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("0")) {
                break;
            }
            answer += Integer.parseInt(strArr[i]);
        }
        return answer;
    }
}
