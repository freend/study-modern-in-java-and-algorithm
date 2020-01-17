package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompleteStackTest {
    CompleteStack completeStack;
    @Before
    public void setUp() {
        this.completeStack = new CompleteStack();
    }

    @Test
    public void getCharAt() {
        String s = "()";
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(1));
    }

    @Test
    public void 짝맞는_스택_확인하기() {
        String s = "()()";
        assertTrue(this.completeStack.completeStack(s));
        s = "(())()";
        assertTrue(this.completeStack.completeStack(s));
        s = ")()(";
        assertFalse(this.completeStack.completeStack(s));
        s = "(()(";
        assertFalse(this.completeStack.completeStack(s));
    }
}