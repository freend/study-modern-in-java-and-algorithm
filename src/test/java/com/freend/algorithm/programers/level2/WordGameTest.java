package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WordGameTest {
    WordGame wordGame;
    @Before
    public void setUp() {
        this.wordGame = new WordGame();
    }

    @Test
    public void 단어게임() {
        int n = 3;
        String[] words = new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        assertThat(this.wordGame.wordGame(n, words), equalTo(new int[] {3, 3}));
        n = 5;
        words = new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
                "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        assertThat(this.wordGame.wordGame(n, words), equalTo(new int[] {0, 0}));
        n = 2;
        words = new String[] {"hello", "one", "even", "never", "now", "world", "draw"};
        assertThat(this.wordGame.wordGame(n, words), equalTo(new int[] {1, 3}));
        n = 2;
        words = new String[] {"land", "dream", "mom", "mom", "ror"};
        assertThat(this.wordGame.wordGame(n, words), equalTo(new int[] {2, 2}));
        n = 2;
        words = new String[] {"qwe", "eqwe", "eqwe"};
        assertThat(this.wordGame.wordGame(n, words), equalTo(new int[] {1, 2}));
    }
}