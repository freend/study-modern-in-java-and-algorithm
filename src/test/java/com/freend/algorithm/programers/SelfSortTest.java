package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SelfSortTest {
    SelfSort selfSort;
    @Before
    public void setUp() {
        this.selfSort = new SelfSort();
    }

    @Test
    public void 내맘대로_정렬하기() {
        String[] strings = new String[] {"sun", "bed", "car"};
        int n = 1;
        assertThat(this.selfSort.SelfSort(strings, n), equalTo(new String[] {"car", "bed", "sun"}));
        strings = new String[] {"abce", "abcd", "cdx"};
        n = 2;
        assertThat(this.selfSort.SelfSort(strings, n), equalTo(new String[] {"abcd", "abce", "cdx"}));
    }
}