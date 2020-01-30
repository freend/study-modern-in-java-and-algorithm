package com.freend.algorithm.hash;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
public class HashTest {
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

    /**
     * 문제 설명
     * 스트리밍 사이트에서 [장르 별]로 [가장 많이 재생된 노래]를 [두 개씩 모아 베스트 앨범을 출시]하려 합니다. 노래는 고유 번호로 구분하며,
     * 노래를 수록하는 기준은 다음과 같습니다.
     *
     * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
     * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
     * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
     * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의
     * 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
     *
     * 제한사항
     * genres[i]는 고유번호가 i인 노래의 장르입니다.
     * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
     * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
     * 장르 종류는 100개 미만입니다.
     * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
     * [모든 장르는 재생된 횟수가 다릅니다].
     * 입출력 예
     * genres	plays	return
     * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
     * 입출력 예 설명
     * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
     *
     * 고유 번호 3: 800회 재생
     * 고유 번호 0: 500회 재생
     * 고유 번호 2: 150회 재생
     * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
     *
     * 고유 번호 4: 2,500회 재생
     * 고유 번호 1: 600회 재생
     * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
     */

    @Test
    public void bestAlbum() {
        String[] genres = {"a", "a", "d", "d", "c", "b"};
        int[] plays = {5, 5, 3, 3, 5, 6};
        System.out.println(albumSolution(genres, plays));

    }

    public int[] albumSolution(String[] genres, int[] plays) {
        Map<String, Map<Integer, Integer>> musicMap = new HashMap<>();
        Map<Integer, Integer> partMap;
        Map<String, Integer> totalMap = new HashMap<>();
        // music map 에 장르별로 분리된 내용을 넣어준다. total map 에 총 수량을 넣어준다.
        for (int i = 0; i < genres.length; i++) {
            // 있다면
            if (musicMap.containsKey(genres[i])) {
                partMap = musicMap.get(genres[i]);
                partMap.put(plays[i], i);

                totalMap.put(genres[i], totalMap.get(genres[i]) + plays[i]);
            } else {
                musicMap.put(genres[i], new TreeMap<>(Comparator.reverseOrder()));
                partMap = musicMap.get(genres[i]);
                partMap.put(plays[i], i);

                totalMap.put(genres[i], plays[i]);
            }
        }

        // 여기서 나갈 순서를 정합니다.
        Map<Integer, String> outCateMap = new TreeMap<>(Comparator.reverseOrder());
        totalMap.forEach((key, value) -> outCateMap.put(value, key));
        List<String> outCateList = new ArrayList<>(outCateMap.values());

        int[] answer = new int[musicMap.size() * 2];

        for (int i = 0; i < outCateList.size(); i++) {
            List<Integer> playsIndex = new ArrayList<>(musicMap.get(outCateList.get(i)).values());
            for (int j = 0; j < playsIndex.size(); j++) {
                answer[i * 2 + j] = playsIndex.get(j);
                if (j == 1) {
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void guavaMultiMap() {
        Multimap<String, String> family = ArrayListMultimap.create();

        family.put("Father Kimchy", "1st Son-Kimchy");
        family.put("Father Kimchy", "1st Daughter-kimchy");
        family.put("Father Jason", "1st Son-Jason");

        Collection<String> child = family.get("Father Kimchy");
        System.out.println(child);
        child = family.get("Father Jason");
        System.out.println(child);
    }
}
