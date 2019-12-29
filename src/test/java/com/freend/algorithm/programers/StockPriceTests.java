package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

public class StockPriceTests {
    StockPrice stockPrice;
    @Before
    public void setUp() {
        stockPrice = new StockPrice();
    }
    @Test
    public void 주식가격() {
        int[] prices = {1, 2, 3, 2, 3};
        int [] result = stockPrice.solution(prices);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}