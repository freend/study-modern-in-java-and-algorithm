package com.freend.algorithm.programers;

public class MiddleString {
    public String solution(String s) {
        if(isPrefixChecker(s)) {
            return s;
        }
        int halfNum = s.length() / 2;
        return (s.length() % 2 == 0) ? s.substring(halfNum - 1, halfNum + 1) : s.substring(halfNum, halfNum + 1);
    }

    private boolean isPrefixChecker(String s) {
        return s.length() < 3;
    }
}
