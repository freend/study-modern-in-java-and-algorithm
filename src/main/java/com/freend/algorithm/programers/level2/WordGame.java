package com.freend.algorithm.programers.level2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordGame {
    public int[] wordsGame(int n, String[] words) {
        int[] result = new int[2];
        Queue<String> queue = new LinkedList<>();
        int user = 0;
        int order = 0;
        String wordString = "";
        queue.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            user = this.getUser(i, n);
            order = this.getOrder(i, n);
            if (isFindSameWord(words[i], wordString)) {
                return new int[] {user, order};
            }
            queue.add(words[i]);
            if (queue.size() == 2) {
                if (isFindQueueWord(queue, words[i])) {
                    return new int[] {user, order};
                }
                if (isCharacterMatching(queue, words[i])) {
                    wordString += queue.poll() + " ";
                } else {
                    return new int[] {user, order};
                }
            }
        }
        return result;
    }

    private boolean isCharacterMatching(Queue<String> queue, String word) {
        return queue.peek().endsWith(String.valueOf(word.charAt(0)));
    }

    private boolean isFindQueueWord(Queue<String> queue, String word) {
        return queue.peek().equals(word);
    }

    private boolean isFindSameWord(String word, String wordString) {
        return wordString.contains(word);
    }

    private int getOrder(int i, int n) {
        return (i / n) + 1;
    }

    private int getUser(int i, int n) {
        return (i % n) + 1;
    }

    public int[] wordGame(int n, String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        int[] result = new int[2];
        hashSet.add(words[0]);
        char endChar = words[0].charAt(words[0].length() - 1);
        char startChar;
        for (int i = 1; i < words.length; i++) {
            hashSet.add(words[i]);
            startChar = words[i].charAt(0);
            if (endChar != startChar || hashSet.size() != i + 1) {
                result[0] = (i % n) + 1;
                result[1] = (i / n) + 1;
                return result;
            }
            endChar = words[i].charAt(words[i].length() - 1);
        }
        return result;
    }
}
