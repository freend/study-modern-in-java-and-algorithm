package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DoublePriorityQueueTest {
    private DoublePriorityQueue doublePriorityQueue;
    @Before
    public void setUp() {
        doublePriorityQueue = new DoublePriorityQueue();
    }

    @Test
    public void 이중우선_큐() {
//        String[] operations = new String[] {"2", "7", "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1", "9", "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        String[] operations = new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = new String[] {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        int[] result = this.doublePriorityQueue.solution(operations);
        for (int value : result) {
            System.out.println(value);
        }
    }
}