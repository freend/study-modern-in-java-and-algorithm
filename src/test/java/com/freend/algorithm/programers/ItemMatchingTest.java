package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemMatchingTest {
    ItemMatching itemMatching;
    @Before
    public void setUp() {
        itemMatching = new ItemMatching();
    }

    @Test
    public void 배열의_길이와_순서대로임을_확인한다() {
        assertTrue(itemMatching.solution(new int[] {1, 2, 3, 4}));
        assertFalse(itemMatching.solution(new int[] {4, 1, 3}));
    }
}