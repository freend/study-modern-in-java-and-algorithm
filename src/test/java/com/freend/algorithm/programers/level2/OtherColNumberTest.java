package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

public class OtherColNumberTest {
    OtherColNumber otherColNumber;
    @Before
    public void setUp() {
        otherColNumber = new OtherColNumber();
    }

    @Test
    public void 가장_큰_수_위치찾기() {
//        assertThat(
//                otherColNumber.columnNumber(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}})
//                , equalTo(16)
//        );
        System.out.println(otherColNumber.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}