package com.freend.algorithm.programers.level3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MultiJumpTest {
    MultiJump multiJump;
    @Before
    public void setUp() {
        multiJump = new MultiJump();
    }

    @Test
    public void 점프의_가지수_구하기() {
       assertThat(multiJump.getJumpCount(4), equalTo(5L));
    }
}