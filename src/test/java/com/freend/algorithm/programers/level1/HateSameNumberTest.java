package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HateSameNumberTest {
    HateSameNumber hateSameNumber;
    @Before
    public void setUp() {
        this.hateSameNumber = new HateSameNumber();
    }

    @Test
    public void 같은_숫자는_싫어() {
        int[] arrs = new int[]{1,1,3,3,0,1,1};
        int[] result = this.hateSameNumber.solution(arrs);
        assertThat(Arrays.toString(result), equalTo(Arrays.toString(new int[]{1,3,0,1})));
    }
}