package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Day2016Test {
    Day2016 day2016;
    @Before
    public void setUp() {
        this.day2016 = new Day2016();
    }

    @Test
    public void 오늘은_무슨요일() {
        assertThat(this.day2016.solution(5, 24), equalTo("TUE"));
    }
}