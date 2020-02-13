package com.freend.algorithm.programers.level3;

public class MultiJump {
    public long getJumpCount(int n) {
        long total = 0;
        long firstNum = 1;
        long secondNum = 2;
        if (n < 3) {
            return n % 1234567;
        }
        else {

            for (int i = 3; i <= n; i++) {
                total = (firstNum + secondNum) % 1234567;
                firstNum = secondNum;
                secondNum = total;
            }
        }
        return total % 1234567;
    }
}
