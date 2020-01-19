package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MatchRemoveTest {
    MatchRemove matchRemove;
    @Before
    public void setUp() {
        this.matchRemove = new MatchRemove();
    }
    @Test
    public void 짝지어_제거하기() {
        assertThat(this.matchRemove.removeMatch("baabaa"), equalTo(1));
        assertThat(this.matchRemove.removeMatch("cdcd"), equalTo(0));
    }
}