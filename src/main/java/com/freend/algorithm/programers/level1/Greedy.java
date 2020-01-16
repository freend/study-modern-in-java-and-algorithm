package com.freend.algorithm.programers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy {
    public int findTraining(int n, int[] lost, int[] reserve) {
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
