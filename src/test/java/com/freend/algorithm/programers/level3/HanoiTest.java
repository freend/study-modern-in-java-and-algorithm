package com.freend.algorithm.programers.level3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HanoiTest {
    Hanoi hanoi;
    @Before
    public void setUp() {
        hanoi = new Hanoi();
    }

    @Test
    public void 하노이의_탑() {
        assertThat(hanoi.hanoiInput(3), equalTo(new int[][]{{1,3},{1,2},{3,2},{1,3},{2,1},{2,3},{1,3}}));
    }
}