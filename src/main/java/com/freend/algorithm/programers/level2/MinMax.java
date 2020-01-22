package com.freend.algorithm.programers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMax {
    public String getMinMax(String s) {
        s = s.trim();
        s += " ";
        String temp = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            temp += String.valueOf(s.charAt(i));
            if (String.valueOf(s.charAt(i)).equals(" ") && !temp.equals("")) {
                temp = temp.trim();
                list.add(Integer.parseInt(temp));
                temp = "";
            }
        }
        Collections.sort(list);
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
