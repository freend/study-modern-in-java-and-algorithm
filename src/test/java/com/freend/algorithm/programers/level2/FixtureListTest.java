package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FixtureListTest {
    FixtureList fixtureList;
    @Before
    public void setUp() {
        fixtureList = new FixtureList();
    }
    @Test
    public void 대진표_만들기() {
        assertThat(fixtureList.findFixture(8, 4, 7), equalTo(3));
    }
}