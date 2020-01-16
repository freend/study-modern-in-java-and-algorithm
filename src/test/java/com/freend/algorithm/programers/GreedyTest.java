package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GreedyTest {
    Greedy greedy;
    @Before
    public void setUp() {
        this.greedy = new Greedy();
    }
    @Test
    public void 체육복을_찾아라() {
        assertThat(this.greedy.findTraining(5, new int[]{2,4,5}, new int[]{1,3,5}), equalTo(5));
    }
}