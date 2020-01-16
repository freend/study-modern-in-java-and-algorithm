package com.freend.algorithm.programers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SelfSort {
    public String[] SelfSort(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        List<SortItem> list = new ArrayList<>();
        for (String value : strings) {
            list.add(new SortItem(String.valueOf(value.charAt(n)), value));
        }

        list.sort(Comparator.comparing(SortItem::getSortString));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getTotalString();
        }
        return answer;
    }
    static class SortItem {
        private String sortString;
        private String totalString;

        public SortItem(String sortString, String totalString) {
            this.sortString = sortString;
            this.totalString = totalString;
        }

        public String getSortString() {
            return sortString;
        }

        public String getTotalString() {
            return totalString;
        }
    }
}
