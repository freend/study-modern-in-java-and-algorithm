package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StrangeLettersTest {
    StrangeLetters strangeLetters;
    @Before
    public void setUp() {
        this.strangeLetters = new StrangeLetters();
    }
    @Test
    public void 이상한_문자열_만들기() {
        String string = "  try   hello world";
        assertThat(this.strangeLetters.solution(string), equalTo("  TrY   HeLlO WoRlD"));
    }
}