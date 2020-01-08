package com.freend.algorithm.programers;

public class GcdLcm {
    // 작은수까지 나오므로 작은수까지 for 문을 돌리면서 둘다 나머지가 0인 것을 구한다.
    public int[] bruteForce(int a, int b) {
        int[] answer = new int[2];
        int minNum = Math.min(a, b);
        int maxNum = Math.max(a, b);
        int gcd = 0;
        for (int i = minNum; i >= 1; i--) {
            if (minNum % i == 0 && maxNum % i == 0) {
                gcd = i;
                break;
            }
        }
        answer[0] = gcd;
        answer[1] = minNum * maxNum / gcd;
        return answer;
    }

    public int[] euclideanAlgorithm(int a, int b) {
        int gcd = getGcd(Math.min(a, b), Math.max(a, b));
        int lcm = a * b / gcd;
        return new int[]{gcd, lcm};
    }
    private int getGcd(int minNum, int maxNum) {
        return (maxNum % minNum == 0) ? minNum : getGcd(maxNum % minNum, minNum);
    }
}
