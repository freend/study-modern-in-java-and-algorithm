package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MiddleStringTest {
    MiddleString middleString;
    @Before
    public void setUp() {
        this.middleString = new MiddleString();
    }

    @Test
    public void 가운데_알파벳을_찾아라() {
        String txt = "aabcdee";
        assertThat(this.middleString.solution(txt), equalTo("c"));

        txt = "qwqwerer";
        assertThat(this.middleString.solution(txt), equalTo("we"));
    }
}