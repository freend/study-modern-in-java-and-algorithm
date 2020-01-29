package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JadenCaseTest {
    JadenCase jadenCase;
    @Before
    public void setUp() {
        jadenCase = new JadenCase();
    }

    @Test
    public void JadenCase_문자열_만들기() {
        assertThat(jadenCase.toJadenCase("3people unFollowed me"), equalTo("3people Unfollowed Me"));
        assertThat(jadenCase.toJadenCase("for the last week"), equalTo("For The Last Week"));
    }
}