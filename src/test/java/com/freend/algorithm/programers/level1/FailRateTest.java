package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FailRateTest {
    FailRate failRate;
    @Before
    public void setUp() {
        this.failRate = new FailRate();
    }
    @Test
    public void 실패율_정렬_배열() {
        int n = 5;
        int[] stage = new int[] {2, 1, 2, 6, 2, 4, 3, 3};
        assertThat(this.failRate.failRateList(n, stage), equalTo(new int[] {3,4,2,1,5}));
        n = 4;
        stage = new int[] {4,4,4,4,4};
        assertThat(this.failRate.failRateList(n, stage), equalTo(new int[] {4,1,2,3}));
    }
}