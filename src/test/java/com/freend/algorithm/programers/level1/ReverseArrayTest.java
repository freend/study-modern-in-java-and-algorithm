package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReverseArrayTest {
    ReverseArray reverseArray;
    @Before
    public void setUp() {
        this.reverseArray = new ReverseArray();
    }

    @Test
    public void 배열뒤집기() {
        int n = 12345;
        assertThat(this.reverseArray.solution(n), equalTo(new int[]{5,4,3,2,1}));
    }
}