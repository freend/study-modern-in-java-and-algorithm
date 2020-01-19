package com.freend.algorithm.programers.level2;

import java.util.Stack;

public class CompleteStack {
    public boolean completeStack(String s) {
        if (String.valueOf(s.charAt(0)).equals(")")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character item : s.toCharArray()) {
            if (item == '(') {
                stack.push(item);
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
