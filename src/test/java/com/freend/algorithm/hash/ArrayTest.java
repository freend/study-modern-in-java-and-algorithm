package com.freend.algorithm.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ArrayTest {
    @Test
    public void 배열에서_원하는_값_찾아오기() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] result = this.numberN(array, commands);
        assertThat(result[0], equalTo(5));
    }

    private int[] numberN(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] sliceList = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(sliceList);
            answer[i] = sliceList[commands[i][2] - 1];
        }
        return answer;
    }

    /**
     * 문제 설명
     * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
     *
     * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
     *
     * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록
     * solution 함수를 작성해주세요.
     *
     * 제한 사항
     * numbers의 길이는 1 이상 100,000 이하입니다.
     * numbers의 원소는 0 이상 1,000 이하입니다.
     * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
     * 입출력 예
     * numbers	return
     * [6, 10, 2]	6210
     * [3, 30, 34, 5, 9]	9534330
     *
     * sorting 참조 : https://developerdk.tistory.com/24
     * 이것을 통해 커스텀 sort에 대해 하나 더 알게 된거 같다.
     */
    @Test
    public void 가장_큰수_만들기() {
        // TODO : test case에서 오류 찾음.
        //[20, 200, 20], [40, 403], [40,405], [40,404], [12,121], [2,22,223], [21,212], [41,415], [2,22 ], [70,0,0,0], [0,0,0,0], [0,0,0,1000], [12,1213]
        int[] input = {20, 200, 20};
        assertThat("가장 큰 수는.", this.solutionBigNumber(input), equalTo("2020200"));
    }

    private String solutionBigNumber(int[] numbers) {
        String answer = "";
        String[] numArr = Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ");

        Arrays.sort(numArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if(numArr[0].equals("0")) return "0";

        for (int i = 0; i < numArr.length; i++) {
            answer += numArr[i];
        }

        return answer;
    }

    @Test
    public void 약수의_합() {
        int guessNum = (int) (Math.random() * 30000);
        guessNum = 5;
        int result = this.sum(guessNum);
        assertThat("결과는 ", result, equalTo(6));
        Function<String, Integer> stringToInt = Integer::parseInt;
    }

    private int sum(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }

    /**
     * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
     * 예를 들어 AB는 1만큼 밀면 BC가 되고, 3만큼 밀면 DE가 됩니다. z는 1만큼 밀면 a가 됩니다.
     * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해보세요.
     *
     * 공백은 아무리 밀어도 공백입니다.
     * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
     * s의 길이는 8000이하입니다.
     * n은 1이상, 25이하인 자연수입니다.
     */
    @Test
    public void 시저암호_풀기() {
        assertThat("일치합니다.", this.ceaser("aBz", 4), equalTo("eFd"));
    }

    private String ceaser(String s, int n) {
        String answer = "";
        char start;
        for (int i = 0; i < s.length(); i++) {
            char ascii = s.charAt(i);
            if (ascii != ' ') {
                start = Character.isLowerCase(ascii) ? 'a' : 'A';
                ascii = (char) (start + (ascii + n - start) % 26);
            }
            answer += ascii;
        }
        return answer;
    }
}
