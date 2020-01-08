package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GcdLcmTest {
    GcdLcm gcdLcm;
    @Before
    public void setUp() {
        this.gcdLcm = new GcdLcm();
    }

    @Test
    public void 무차별검색() {
        assertThat(this.gcdLcm.bruteForce(3, 12), equalTo(new int[]{3, 12}));
        assertThat(this.gcdLcm.euclideanAlgorithm(1071, 1029), equalTo(new int[]{21, 52479}));
        assertThat(this.gcdLcm.euclideanAlgorithm(78696, 19332), equalTo(new int[]{36, 42259752}));
    }
}