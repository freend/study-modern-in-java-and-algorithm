package com.freend.algorithm.programers.level2;

import java.util.Stack;

public class Tower {
    public int[] towerLogic(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            stack.push(heights[i]);
        }

        int receiveNum;
        for (int i = 0; i < heights.length; i++) {
            int sendNum = stack.pop();
            receiveNum = 0;
            for (int j = stack.size() - 1; j >= 0 ; j--) {
                if (stack.get(j) > sendNum) {
                    receiveNum = j + 1;
                    break;
                }
            }
            answer[heights.length - (i + 1)] = receiveNum;
        }

        return answer;
    }
}
