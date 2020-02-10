package com.freend.algorithm.programers.level3;

public class Country124 {
    public String solution(int n) {
        String answer = "";
        while (n > 0) {
            int rest = n % 3;
            n = n / 3;
            if (rest == 0) {
                rest = 4;
                n --;
            }
            answer = rest + answer;
        }
        return answer;
    }
}
