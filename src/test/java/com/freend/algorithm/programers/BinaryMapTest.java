package com.freend.algorithm.programers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryMapTest {
    BinaryMap binaryMap;
    @Before
    public void setUp() {
        this.binaryMap = new BinaryMap();
    }
    @Test
    public void binaryMap() {
        int n = 5;
        int[] arr1 = new int[] {9, 20, 28, 18, 11};
        int[] arr2 = new int[] {30, 1, 21, 17, 28};
        assertThat(this.binaryMap.binaryMap(n, arr1, arr2), equalTo(new String[]{"#####", "# # #", "### #", "#  ##", "#####"}));
    }
    @Test
    public void beforeBinaryMap() {
        int n = 6;
        int[] arr1 = new int[] {46, 33, 33 ,22, 31, 50};
        int[] arr2 = new int[] {27 ,56, 19, 14, 14, 10};
        assertThat(this.binaryMap.beforeBinaryMap(n, arr1, arr2), equalTo(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "}));
    }
}