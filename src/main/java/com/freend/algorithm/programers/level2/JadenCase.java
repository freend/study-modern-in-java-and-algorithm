package com.freend.algorithm.programers.level2;

public class JadenCase {
    public String toJadenCase(String s) {
        s = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            result.append(
                    (flag) ? String.valueOf(s.charAt(i)).toUpperCase() : String.valueOf(s.charAt(i))
            );
            flag = s.charAt(i) == 32;
        }
        return result.toString();
    }
}
