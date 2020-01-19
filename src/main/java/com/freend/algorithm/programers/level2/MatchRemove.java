package com.freend.algorithm.programers.level2;

import java.util.Stack;

public class MatchRemove {
    public int removeMatch(String s) {
        Stack<Character> stack = new Stack<>();
        for (char item : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == item) {
                stack.pop();
            } else {
                stack.push(item);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
