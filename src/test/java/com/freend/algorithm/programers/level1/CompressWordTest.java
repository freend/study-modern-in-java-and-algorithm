package com.freend.algorithm.programers.level1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CompressWordTest {
    CompressWord compressWord;
    @Before
    public void setUp() {
        this.compressWord = new CompressWord();
    }
    @Test
    public void 문자압축하기() {
        String words = "abcabcabcabcdededededede";
//        assertThat("제일 작은 수는 14입니다.", compressWord.solution(words), equalTo(14));

        words = "aabbaccc";
//        assertThat("제일 작은 수는 7입니다.", compressWord.solution(words), equalTo(7));

        words = "ababcdcdababcdcd";
        assertThat("제일 작은 수는 9입니다.", compressWord.solution(words), equalTo(9));

        words = "abcabcdede";
        assertThat("제일 작은 수는 8입니다.", compressWord.solution(words), equalTo(8));

        words = "xababcdcdababcdcd";
        assertThat("제일 작은 수는 17입니다.", compressWord.solution(words), equalTo(17));
    }
}