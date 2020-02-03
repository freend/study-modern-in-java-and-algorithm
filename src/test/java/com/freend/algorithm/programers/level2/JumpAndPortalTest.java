package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JumpAndPortalTest {
    JumpAndPortal jumpAndPortal;
    @Before
    public void setUp() {
        jumpAndPortal = new JumpAndPortal();
    }
    @Test
    public void 점프_최적화() {
        assertThat(jumpAndPortal.movingBattery(5), equalTo(2));
        assertThat(jumpAndPortal.movingBattery(6), equalTo(2));
        assertThat(jumpAndPortal.movingBattery(5000), equalTo(5));
    }
}