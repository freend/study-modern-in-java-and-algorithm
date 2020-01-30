package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class RunnerTest {
    Runner runner;

    @Before
    public void setUp() {
        runner = new Runner();
    }
    @Test
    public void 완주하지_못한_선수() {
        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};
        assertThat("정답은 leo", runner.completionSolution(participant, completion), equalTo("leo"));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        assertThat("정답은 vinko", runner.completionSolution(participant, completion), equalTo("vinko"));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        assertThat("정답은 mislav", runner.completionSolution(participant, completion), equalTo("mislav"));
    }
}