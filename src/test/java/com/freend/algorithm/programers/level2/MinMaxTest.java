package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinMaxTest {
    MinMax minMax;
    @Before
    public void setUp() {
        this.minMax = new MinMax();
    }
    @Test
    public void 최대_최소값_구하기() {
        String s = " ";
        assertThat(this.minMax.getMinMax("-1 -2 -3 -4"), equalTo("-4 -1"));
    }
}