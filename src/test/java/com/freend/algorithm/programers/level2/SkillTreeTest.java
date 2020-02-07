package com.freend.algorithm.programers.level2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SkillTreeTest {
    SkillTree skillTree;
    @Before
    public void setUp() {
        this.skillTree = new SkillTree();
    }

    @Test
    public void 구현가능한_스킬트리의_갯수를반환하라() {
        String[] skillTress = new String[] {"BACDE", "CBADF", "AECB", "YUIOP", "ZWGHTJGC", "B"};
        String skill = "CBD";
        assertThat(this.skillTree.skillTree(skill, skillTress), equalTo(3));
    }
}