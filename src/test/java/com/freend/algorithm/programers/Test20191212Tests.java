package com.freend.algorithm.programers;

import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@RunWith(SpringJUnit4ClassRunner.class)
public class Test20191212Tests {
    /**
     * 문제 설명
     * 대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는
     * solution를 완성하세요. 'p', 'y'
     * 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
     *
     * 예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.
     *
     * 제한사항
     * 문자열 s의 길이 : 50 이하의 자연수
     * 문자열 s는 알파벳으로만 이루어져 있습니다.
     * 입출력 예
     * s	answer
     * pPoooyY	true
     * Pyy	false
     * 입출력 예 설명
     * 입출력 예 #1
     * 'p'의 개수 2개, 'y'의 개수 2개로 같으므로 true를 return 합니다.
     *
     * 입출력 예 #2
     * 'p'의 개수 1개, 'y'의 개수 2개로 다르므로 false를 return 합니다.
     */
    @Test
    public void 단어체크() {
        int code = (int) "p".charAt(0);
        System.out.println("code p: " + code);

        code = (int) "P".charAt(0);
        System.out.println("code P: " + code);

        code = (int) "y".charAt(0);
        System.out.println("code y: " + code);

        code = (int) "Y".charAt(0);
        System.out.println("code Y: " + code);

        System.out.println(this.wordChecker("fldsjfosdjfpPpPpPyyyyyyodsfjof"));
    }
    private boolean wordChecker(String s) {
        boolean answer = true;
        Integer countP = 0;
        Integer countY = 0;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            char code = s.charAt(i);
            if (code == 80) {
                countP ++;
            } else if (code == 89) {
                countY ++;
            }
        }
        if (countP == 0 && countY == 0) {
            return true;
        }
        return countP.compareTo(countY) == 0 ? true : false;
    }

    /**
     * 문제 설명
     * 점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
     * 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나
     * 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
     * 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을
     * 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
     *
     * 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가
     * 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의
     * 최댓값을 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * 전체 학생의 수는 2명 이상 30명 이하입니다.
     * 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
     * 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
     * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
     * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에
     * 다른 학생에게는 체육복을 빌려줄 수 없습니다.
     * 입출력 예
     * n	lost	reserve	return
     * 5	[2, 4]	[1, 3, 5]	5
     * 5	[2, 4]	[3]	4
     * 3	[3]	[1]	2
     * 입출력 예 설명
     *
     * 문제해설
     * https://rain-bow.tistory.com/entry/Python-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B2%B4%EC%9C%A1%EB%B3%B5
     *
     * 위 사이트에 보면 중복을 지우는 기능에 대한 설명이 있다. 이것과 동일한 기능이 자바도 있다.
     * https://emessell.tistory.com/14
     *
     * JDK 에서 교집합, 차집합 등등은 boolean을 반환해서 효율성이 떨어진다는 생각이 들었다. 그래서 검색도중 다음 사이트를 방문하게 되었다.
     * http://docs.likejazz.com/intersection-of-two-sets/
     * 이 사이트를 보던중 이정도까지의 노력이 필요하다는 것을 알게되었다. 이런걸 실무하다가 찾으면 늦게되는 문제가 된다. 평상시에 공부를 해야하는 이유 추가.
     * 설치해서 쓰던거긴 한데 guava가 교집합에 더 빠른 성능을 보게 되었다.
     * 또한 결과값을 set으로 반환하는 것도 괜찮았다.
     * guava에 대한 설명은 outsider님의 블로그를 참조하자
     * https://blog.outsider.ne.kr/710
     */
    @Test
    public void 체육복을_찾아라() {
        System.out.println(this.findTraining(5, new int[]{2,4,5}, new int[]{1,3,5}));
    }

    private int findTraining(int n, int[] lost, int[] reserve) {
        // 여분과 잃어버린 사람의 중복을 제거한다.
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        // removeall 하면 boolean 을 반환하기에 한번 더 했다.
        Set<Integer> reserveSet = new TreeSet<>(reserveList);
        Set<Integer> lostSet = new TreeSet<>(lostList);

        reserveSet.removeAll(lostSet);

        Set<Integer> reserveSource = new HashSet<>(reserveList);
        lostSet.removeAll(reserveSource);

        int resultMax = n - lostSet.size();

        reserveList = new ArrayList<>(reserveSet);
        for (Integer item : reserveList) {
            if (lostSet.contains(item - 1)) {
                lostSet.remove(item - 1);
                resultMax ++;
            } else if (lostSet.contains(item + 1)) {
                lostSet.remove(item + 1);
                resultMax ++;
            }
        }

        // Hash Set으로 만들어서 중복을 제거하면 된다.
        return resultMax;
    }
}
