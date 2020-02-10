package com.freend.algorithm.programers.level3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Country124Test {
    Country124 country124;
    @Before
    public void setUp() {
        country124 = new Country124();
    }
    @Test
    public void 나라의_숫자() {
        assertThat(country124.solution(9), equalTo("24"));
    }
}