package com.freend.algorithm.programers.level2;

public class JumpAndPortal {
    public int movingBattery(int num) {
        int jump = 0;
        while(num != 0) {
            if (num % 2 == 1) {
                num -= 1;
                jump ++;
            }
            num = num / 2;

        }
        return jump;
    }
}
