package com.freend.algorithm.programers.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class BridgeTruckTests {
    BridgeTruck bridgeTruck;
    @Test
    public void setUp() {
        bridgeTruck = new BridgeTruck();
    }
    @Test
    public void 다리를_지나는_트럭() {
        assertThat(bridgeTruck.bridgeTruck(2, 10, new int[]{7, 4, 5, 6}), equalTo(8));
        assertThat(bridgeTruck.bridgeTruck(100, 100, new int[]{10}), equalTo(101));
        assertThat(bridgeTruck.bridgeTruck(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10})
                , equalTo(110));
        assertThat(bridgeTruck.bridgeTruck(1, 2, new int[]{1, 1, 1}), equalTo(4));
        assertThat(bridgeTruck.bridgeTruck(1, 1, new int[]{1, 1, 1}), equalTo(4));
        assertThat(bridgeTruck.bridgeTruck(4, 2, new int[]{1, 1, 1, 1}), equalTo(10));
        assertThat(bridgeTruck.bridgeTruck(3, 3, new int[]{1, 1, 1}), equalTo(6));
        assertThat(bridgeTruck.bridgeTruck(3, 1, new int[]{1, 1, 1}), equalTo(10));
        assertThat(bridgeTruck.bridgeTruck(5, 5, new int[]{1, 1, 1, 1, 1, 2, 2})
                , equalTo(14));
        assertThat(bridgeTruck.bridgeTruck(7, 7, new int[]{1, 1, 1, 1, 1, 3, 3})
                , equalTo(18));
        assertThat(bridgeTruck.bridgeTruck(5, 5, new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2})
                , equalTo(19));
        assertThat(bridgeTruck.bridgeTruck(5, 5, new int[]{2, 2, 2, 2, 2, 1, 1, 1, 1})
                , equalTo(21));
    }
}
