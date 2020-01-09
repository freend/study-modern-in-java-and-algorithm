package com.freend.algorithm.programers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EasyAlgorithm {
    public int[][] addMatrix(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = addItem(arr1[i], arr2[i]);
        }
        return result;
    }
    private int[] addItem(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }

    /**
     * 문제 설명
     * 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고
     * 3이라면 수박수를 리턴하면 됩니다.
     *
     * 제한 조건
     * n은 길이 10,000이하인 자연수입니다.
     * 입출력 예
     * n	return
     * 3	수박수
     * 4
     * @param n
     * @return
     */
    public String repeatCharacter(int n) {
        String answer = "";
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (i % 2 == 0) ? "수" : "박";
        }
        return Arrays.stream(arr).collect(Collectors.joining());
    }

    /**
     * 문제 설명
     * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
     *
     * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
     * (1은 소수가 아닙니다.)
     *
     * 제한 조건
     * n은 2이상 1000000이하의 자연수입니다.
     * 입출력 예
     * n	result
     * 10	4
     * 5	3
     * 입출력 예 설명
     * 입출력 예 #1
     * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
     *
     * 입출력 예 #2
     * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
     * @param n
     * @return
     */
    public int primeNumber(int n) {
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 2; i <= n; i++) {
            arr[i - 2] = i;
        }
        for (int i = 2; i <= arr.length; i++) {
            for (int j = 2 * i; j <= arr.length; j += i) {
                arr[j - 2] = 0;
            }
        }
        Arrays.sort(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            answer ++;
            if (arr[i - 1] == 0) {
                return answer;
            }
        }
        return answer;
    }

    public int sumCommonDivide(int n) {
        int answer = 0;
        for (int i = 1; i <= (n / 2); i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        answer += n;
        return answer;
    }

    public String findKim(String[] seoul) {
        int pos = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                pos = i;
                break;
            }
        }
        return "김서방은 " + pos + "에 있다";
    }

    public long[] intervalArray(int x, int n) {
        long[] arr = new long[n];
        for (int i = 1; i <= n; i++) {
            arr[(i - 1)] = Long.valueOf(x * i);
        }

        return arr;
    }

    public int greedyBudget(int[] d, int budget) {
        Arrays.sort(d);
        int total = 0;
        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            total += d[i];
            answer ++;
            if (total > budget) {
                answer --;
                break;
            }
        }
        return answer;
    }
}
