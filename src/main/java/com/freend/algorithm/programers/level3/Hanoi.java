package com.freend.algorithm.programers.level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hanoi {
    private List<int[]> list = new ArrayList<>();
    public int[][] hanoiInput(int n) {
        Stacks startStack = new Stacks(1);
        Stacks viaStack = new Stacks(2);
        Stacks endStack = new Stacks(3);

        for (int i = n; i > 0; i--) {
            startStack.setStack(i);
        }
        solveHanoi(n, startStack, endStack, viaStack);
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private void solveHanoi(int n, Stacks start, Stacks end, Stacks via) {
        if(n == 1) {
            moving(start, end);
        } else {
            solveHanoi(n - 1, start, via, end);
            moving(start, end);
            solveHanoi(n - 1, via, end, start);
        }
    }
    private void moving(Stacks from, Stacks to) {
        list.add(new int[] {from.getPos(), to.getPos()});
        to.setStack(from.removeStack());
    }
    private static class Stacks {
        private int pos;
        private Stack<Integer> stack;

        public Stacks(int pos) {
            this.pos = pos;
            this.stack = new Stack<>();
        }

        public int getPos() {
            return pos;
        }

        public int removeStack() {
            return stack.pop();
        }

        public void setStack(int num) {
            this.stack.add(num);
        }
    }
}
