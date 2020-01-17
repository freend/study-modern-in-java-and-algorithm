package com.freend.algorithm.programers.level2;

import java.util.Stack;

public class CompleteStack {
    public boolean completeStack(String s) {
        if (String.valueOf(s.charAt(0)).equals(")")) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
