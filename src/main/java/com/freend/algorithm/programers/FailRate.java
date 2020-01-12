package com.freend.algorithm.programers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FailRate {
    int maxStage;
    int totalGamer;
    int[] userStage;
    int[] result;
    List<StageMember> stageList;
    public int[] failRateList(int n, int[] stage) {
        maxStage = n;
        totalGamer = stage.length;
        userStage = stage;

        this.result = new int[this.maxStage];
        this.stageList = new ArrayList<>();

        prefixAddStageMemberInstance();
        updateEachStagePerUser();
        calculateEachStageUserRate();
        removeZeroStage();

        stageList.sort(Comparator.comparing(StageMember::getStageUserRate, Comparator.reverseOrder()));
        cloneStageListToArray();
        return this.result;
    }

    private void cloneStageListToArray() {
        for (int i = 0; i < this.result.length; i++) {
            this.result[i] = stageList.get(i).getStageNum();
        }
    }

    private void removeZeroStage() {
        stageList.remove(0);
    }

    private void calculateEachStageUserRate() {
        for (int i = 0; i <= this.maxStage; i++) {
            StageMember stageMember = stageList.get(i);
            stageMember.stageRate(totalGamer);
            stageList.set(i, stageMember);
            totalGamer -= stageMember.getStageUser();
        }
    }

    private void updateEachStagePerUser() {
        for (int i = 0; i < this.totalGamer; i++) {
            if (this.userStage[i] <= this.maxStage) {
                StageMember stageMember = this.stageList.get(this.userStage[i]);
                stageMember.updateUser();
                this.stageList.set(userStage[i], stageMember);
            }
        }
    }

    private void prefixAddStageMemberInstance() {
        for (int i = 0; i < this.maxStage + 1; i++) {
            this.stageList.add(new StageMember(i));
        }
    }

    private static class StageMember {
        private int stageNum;
        private double stageUser;
        private double stageUserRate;

        public int getStageNum() {
            return stageNum;
        }

        public double getStageUser() {
            return stageUser;
        }

        public double getStageUserRate() {
            return stageUserRate;
        }

        public StageMember(int stageNum) {
            this.stageNum = stageNum;
            this.stageUserRate = 0.0;
        }

        public void updateUser() {
            this.stageUser += 1.0;
        }

        public void stageRate(int totalUser) {
            if (this.stageUser != 0) {
                this.stageUserRate = this.stageUser / totalUser;
            }
        }
    }
}
