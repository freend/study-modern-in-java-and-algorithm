package com.freend.algorithm.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
public class HashTest {
    /**
     * Programmers 사용한 이유.
     * 제출시 호율성 체크가 있어서 단순히 수식을 해결하는 수준에서 멈추면 안된다.
     */
    /**
     * 문제 설명
     * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
     *
     * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을
     * return 하도록 solution
     * 함수를 작성해주세요.
     *
     * 제한사항
     * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
     * completion의 길이는 participant의 길이보다 1 작습니다.
     * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
     * 참가자 중에는 동명이인이 있을 수 있습니다.
     */
    @Test
    public void 완주하지_못한_선수() {
        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};
        assertThat("정답은 leo", this.completionSolution(participant, completion), equalTo("leo"));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        assertThat("정답은 vinko", this.completionSolution(participant, completion), equalTo("vinko"));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        assertThat("정답은 mislav", this.completionSolution(participant, completion), equalTo("mislav"));
    }

    private String completionSolution(String[] participant, String[] completion) {
        List<String> partList = Arrays.asList(participant);
        List<String> completionList = Arrays.asList(completion);

        partList.sort(Comparator.naturalOrder());
        completionList.sort(Comparator.naturalOrder());

        for (int i = 0; i < partList.size() - 1; i++) {
            if (!partList.get(i).equals(completionList.get(i))) {
                return partList.get(i);
            }
        }
        return  partList.get(partList.size() - 1);
    }

    /**
     * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
     * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
     *
     * 구조대 : 119
     * 박준영 : 97 674 223
     * 지영석 : 11 9552 4421
     * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면
     * false를 그렇지 않으면 true를
     * return 하도록 solution 함수를 작성해주세요.
     */
    @Test
    public void 폰북체커() {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        assertFalse("중복이 존재함니다.", phoneBookSolution(phoneBook));

        phoneBook = new String[]{"123", "456", "789"};
        assertTrue("중복이 존재하지 않습니다.", phoneBookSolution(phoneBook));

        phoneBook = new String[]{"12","123","1235","567","88"};
        assertFalse("중복이 존재함니다.", phoneBookSolution(phoneBook));

        phoneBook = new String[]{"819232312", "976", "119552", "2"};
        assertTrue("중복이 존재하지 않습니다.", phoneBookSolution(phoneBook));
    }
    private boolean phoneBookSolution(String[] phone_book) {
        List<String> phoneBook = Arrays.asList(phone_book);
        phoneBook.sort(Comparator.naturalOrder());
        System.out.println("list : " + phoneBook);
        for (int i = 0; i < phoneBook.size() - 1; i++) {
            // startWith : prefix check, contains : contain word, endWith : surfix check
            if (phoneBook.get(i + 1).startsWith(phoneBook.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
     *
     * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경
     * 대신 검정 선글라스를 착용하거나 해야 합니다.
     *
     * 종류	이름
     * 얼굴	동그란 안경, 검정 선글라스
     * 상의	파란색 티셔츠
     * 하의	청바지
     * 겉옷	긴 코트
     * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
     *
     * 제한사항
     * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
     * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
     * 같은 이름을 가진 의상은 존재하지 않습니다.
     * clothes의 모든 원소는 문자열로 이루어져 있습니다.
     * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
     * 스파이는 하루에 최소 한 개의 의상은 입습니다.
     * 입출력 예
     * clothes	return
     * [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
     * [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
     * 입출력 예 설명
     * 예제 #1
     * headgear에 해당하는 의상이 yellowhat, greenturban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이
     * 가능합니다.
     *
     * 1. yellow_hat
     * 2. blue_sunglasses
     * 3. green_turban
     * 4. yellow_hat + blue_sunglasses
     * 5. green_turban + blue_sunglasses
     * 예제 #2
     * face에 해당하는 의상이 crowmask, bluesunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
     *
     * 1. crow_mask
     * 2. blue_sunglasses
     * 3. smoky_makeup
     */
    @Test
    public void camouflage() {
        String[][] array = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int counter = camouflageSolution(array);
    }

    private int camouflageSolution(String[][] clothes) {
        TreeMap<String, Integer> categoryMap = new TreeMap<>();
        int answer = 1;
        // 종류별로 모으기
        for (int i = 0; i < clothes.length; i++) {
            categoryMap.putIfAbsent(clothes[i][1], 1);
            categoryMap.put(clothes[i][1], categoryMap.get(clothes[i][1]) + 1);
        }
        // 각 원소를 곱하기
        List<Integer> list = new ArrayList<>(categoryMap.values());
        for (int i = 0; i < list.size(); i++) {
            answer = answer * list.get(i);
        }
        // 아무것도 없는 경우 -1 후 반환.
        return answer - 1;
    }
}
