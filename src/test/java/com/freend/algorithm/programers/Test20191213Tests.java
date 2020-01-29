package com.freend.algorithm.programers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Test20191213Tests {
    /**
     * 문제 설명
     * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
     * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
     *
     * 제한사항
     * N의 범위 : 100,000,000 이하의 자연수
     * 입출력 예
     * N	answer
     * 123	6
     * 987	24
     * 입출력 예 설명
     * 입출력 예 #1
     * 문제의 예시와 같습니다.
     *
     * 입출력 예 #2
     * 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
     */
    @Test
    public void 자릿수_더하기() {
        assertThat(placeValue(987), equalTo(24));
    }
    private int placeValue(int n) {
        int answer = 0;
        String numToString = String.valueOf(n);
        String[] stringToArray = numToString.split("");
        for (int i = 0; i < stringToArray.length; i++) {
            answer += Integer.parseInt(stringToArray[i]);
        }
        return answer;
    }

    /**
     * 문제 설명
     * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
     *
     * 제한 사항
     * n은 0 이상 3000이하인 정수입니다.
     * 입출력 예
     * n	return
     * 12	28
     * 5	6
     * 입출력 예 설명
     * 입출력 예 #1
     * 12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
     *
     * 입출력 예 #2
     * 5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
     */
    @Test
    public void 약수의_합() {
        assertThat(sumFactor(12), equalTo(28));
    }
    private int sumFactor(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (n % i == 0) ? i : 0;
        }
        return answer;
    }
}
