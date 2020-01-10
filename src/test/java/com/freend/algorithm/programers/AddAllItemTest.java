package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

public class AddAllItemTest {
    AddAllItem addAllItem;
    @Before
    public void setUp() {
        this.addAllItem = new AddAllItem();
    }

    @Test
    public void 자리수_더하기() {
        int s = 987;
        this.addAllItem.solution(s);
    }
}