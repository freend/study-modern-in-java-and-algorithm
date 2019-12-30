package com.freend.algorithm.programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MathExamination {
    public int[] solution(int[] answers) {
        // 각 패턴을 입력한다.
        int[] firstPattern = {1,2,3,4,5};
        int[] secondPattern = {2,1,2,3,2,4,2,5};
        int[] thirdPattern = {3,3,1,1,2,2,4,4,5,5};

        // 정답을 저장하는 배열을 생성한다.
        Students[] studentsArr = new Students[3];
        for (int i = 0; i < studentsArr.length; i++) {
            studentsArr[i] = new Students(i + 1);
        }

        // 답안지와 비교한다.
        for (int i = 0; i < answers.length; i++) {
            studentsArr[0].rightCount += (firstPattern[i % firstPattern.length] == answers[i]) ? 1 : 0;
            studentsArr[1].rightCount += (secondPattern[i % secondPattern.length] == answers[i]) ? 1 : 0;
            studentsArr[2].rightCount += (thirdPattern[i % thirdPattern.length] == answers[i]) ? 1 : 0;
        }

        // 최고점자를 뽑는다.
        Comparator<Students> comparator = Comparator.comparing(Students::getRightCount).reversed();
        Arrays.sort(studentsArr, comparator);

        List<Integer> resultList = new ArrayList<>();
        resultList.add(studentsArr[0].getId());
        // 동점자를 뽑는다.
        for (int i = 1; i < studentsArr.length; i++) {
            if (studentsArr[i].getRightCount() == studentsArr[i - 1].getRightCount()) {
                resultList.add(studentsArr[i].getId());
            } else {
                break;
            }
        }
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
    private class Students {
        private int id;
        private int rightCount = 0;

        public Students(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public int getRightCount() {
            return rightCount;
        }
    }
}