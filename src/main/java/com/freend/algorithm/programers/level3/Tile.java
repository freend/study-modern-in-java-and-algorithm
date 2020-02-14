package com.freend.algorithm.programers.level3;

public class Tile {
    public int tile2X(int n) {
        if (n < 4) {
            return n;
        }
        long firstNum = 2;
        long secondNum = 3;
        long totalNum = 0;
        for (int i = 4; i <= n; i++) {
            totalNum = (firstNum + secondNum) % 1000000007;
            firstNum = secondNum;
            secondNum = totalNum;
        }
        return (int) totalNum;
    }
}
