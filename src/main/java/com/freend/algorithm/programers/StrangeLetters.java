package com.freend.algorithm.programers;

public class StrangeLetters {
    public String solution(String s) {
        StringBuffer result = new StringBuffer();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 32) {
                idx = 0;
                result.append(s.charAt(i));
            } else {
                String chars = (idx % 2 == 0) ? String.valueOf(s.charAt(i)).toUpperCase()
                        : String.valueOf(s.charAt(i)).toLowerCase();
                result.append(chars);
                idx ++;
            }
        }
        return result.toString();
    }
}
