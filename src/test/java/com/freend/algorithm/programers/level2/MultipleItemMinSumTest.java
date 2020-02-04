package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MultipleItemMinSumTest {
    MultipleItemMinSum multipleItemMinSum;
    @Before
    public void setUp() {
        multipleItemMinSum = new MultipleItemMinSum();
    }

    @Test
    public void 최소값_구하기() {
        assertThat(multipleItemMinSum.numSum(new int[] {1, 4, 2}, new int[] {5, 4, 4}), equalTo(29));
        assertThat(multipleItemMinSum.numSum(new int[] {1, 2}, new int[] {3, 4}), equalTo(10));
    }
}