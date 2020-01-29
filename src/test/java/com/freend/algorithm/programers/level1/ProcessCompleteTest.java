package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProcessCompleteTest {
    ProcessComplete processComplete;
    @Before
    public void setUp() {
        processComplete = new ProcessComplete();
    }
    @Test
    public void 작업완료_배열() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        assertThat(processComplete.completeProcess(progresses, speeds), equalTo(new int[] {2, 1}));
    }
}