package com.freend.algorithm.programers;

import java.util.LinkedList;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        LinkedList<Integer> priceQueue = new LinkedList<>();
        for (int value : prices) {
            priceQueue.add(value);
        }
        // 즉 마지막 원소는 0, 마지막 바로앞의 원소는 1이다.
        while (priceQueue.size() > 2) {
            int price = priceQueue.poll(); // 첫번째 원소를 뺀다.
            for (int i = 0; i < priceQueue.size() - 1; i++) {
                if (price > priceQueue.get(i)) {
                    answer[prices.length - (priceQueue.size() + 1)] = i + 1;
                    break;
                }
                if (i == priceQueue.size() - 2) {
                    answer[prices.length - (priceQueue.size() + 1)] = i + 2;
                    break;
                }
            }
        }
        answer[answer.length - 2] = 1;
        return answer;
    }
}
