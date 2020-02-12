package com.freend.algorithm.programers.level3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FoldedThePaperTest {
    FoldedThePaper foldedThePaper;
    @Before
    public void setUp() {
        foldedThePaper = new FoldedThePaper();
    }
    @Test
    public void 종이접기() {
        assertThat(foldedThePaper.foldPaper(3), equalTo(new int[] {0,0,1,0,0,1,1}));
    }
}