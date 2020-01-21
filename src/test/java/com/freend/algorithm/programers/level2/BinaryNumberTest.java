package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BinaryNumberTest {
    BinaryNumber binaryNumber;
    @Before
    public void setUp() {
        this.binaryNumber = new BinaryNumber();
    }
    @Test
    public void 다음의_큰수는() {
        assertThat(this.binaryNumber.getNextNumber(78), equalTo(83));
    }
    @Test
    public void 비트_연산자로_풀이() {
        assertThat(nextBigNumber(78), equalTo(83));
    }
    public int nextBigNumber(int n) {
        int postPattern = n & -n;
        int smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}