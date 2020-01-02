package com.freend.algorithm.programers;

import java.util.*;

public class CompressWord {
    private Queue<String> wordsQueue;
    private List<WordsFactory> compressList;
    public int solution(String words) {
        // word length 1
        if (words.length() == 1) {
            return words.length();
        }
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int cutLimit = words.length() / 2;
        for (int i = 1; i <= cutLimit; i++) {
            priorityQueue.add(joinFactory(words, i));
        }
        return priorityQueue.poll();
    }

    private int joinFactory(String words, int cutCount) {
        this.wordsQueue = new LinkedList<>();
        this.compressList = new ArrayList<>();

        Collections.addAll(wordsQueue, words.split(""));

        while (!wordsQueue.isEmpty()) {
            String divideWords = getWords(cutCount);
            compressUpdate(divideWords);
        }

        StringBuilder compressResult = new StringBuilder();
        for (WordsFactory item : compressList) {
            compressResult.append(item.toResult());
        }

        return compressResult.length();
    }

    private void compressUpdate(String divideWords) {
        if (compressList.isEmpty()) {
            compressList.add(newItem(divideWords));
        } else {
            if (divideWords.equals(compressList.get(compressList.size() - 1).getWords())) {
                compressList.get(compressList.size() - 1).addCounts();
            } else {
                compressList.add(newItem(divideWords));
            }
        }
    }

    private String getWords(int cutCount) {
        StringBuilder divideWords = new StringBuilder();
        for (int i = 0; i < cutCount; i++) {
            divideWords.append(wordsQueue.poll());
            if (wordsQueue.isEmpty()) {
                break;
            }
        }
        return divideWords.toString();
    }

    private WordsFactory newItem(String words) {
        return new WordsFactory(words);

    }
    // inner class
    private static class WordsFactory {
        private int counts;
        private String words;

        public WordsFactory(String words) {
            this.words = words;
            this.counts = 1;
        }

        public String getWords() {
            return words;
        }

        public void addCounts() {
            this.counts ++;
        }

        public String toResult() {
            return (counts == 1) ? words : counts + words;
        }
    }
}
