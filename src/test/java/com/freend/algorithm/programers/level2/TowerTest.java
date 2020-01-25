package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TowerTest {
    Tower tower;
    @Before
    public void setUp() {
        tower = new Tower();
    }
    @Test
    public void 송수신_탑() {
        int[] heights = new int[]{7, 6, 5, 4, 3, 2, 1};
        assertThat(tower.towerLogic(heights), equalTo(new int[] {0, 1, 2, 3, 4, 5, 6}));
        heights = new int[]{6, 9, 5, 7, 4};
        assertThat(tower.towerLogic(heights), equalTo(new int[] {0,0,2,2,4}));
        heights = new int[]{3,9,9,3,5,7,2};
        assertThat(tower.towerLogic(heights), equalTo(new int[] {0,0,0,3,3,3,6}));
        heights = new int[]{1,5,3,6,7,6,5};
        assertThat(tower.towerLogic(heights), equalTo(new int[] {0,0,2,0,0,5,6}));
    }
}