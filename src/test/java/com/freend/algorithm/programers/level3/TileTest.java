package com.freend.algorithm.programers.level3;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TileTest {
    Tile tile;
    @Before
    public void setUp() {
        tile = new Tile();
    }

    @Test
    public void 타일의_배열수_맞추기() {
        assertThat(tile.tile2X(4), equalTo(5));
    }
}