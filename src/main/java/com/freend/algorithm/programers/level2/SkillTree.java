package com.freend.algorithm.programers.level2;

public class SkillTree {
    public int skillTree(String skill, String[] skillTrees) {
        int answer = 0;
        for (int i = 0; i < skillTrees.length; i++) {
            answer += this.skillMatch(skillTrees[i], skill);
        }
        return answer;
    }

    private int skillMatch(String tree, String skill) {
        int idx = 0;
        for (int i = 0; i < tree.length(); i++) {
            int matchNum = skill.indexOf(tree.charAt(i));
            if (matchNum != -1) {
                if (idx != matchNum) {
                    return 0;
                } else {
                    idx ++;
                }
            }
        }
        return 1;
    }
}
