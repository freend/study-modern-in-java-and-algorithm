package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

public class CollatzGuessTest {
    CollatzGuess collatzGuess;
    @Before
    public void setUp() {
        this.collatzGuess = new CollatzGuess();
    }
    @Test
    public void 콜라츠_추측() {
        System.out.println("count : " + collatzGuess.collatzGuess(626331));
    }
}