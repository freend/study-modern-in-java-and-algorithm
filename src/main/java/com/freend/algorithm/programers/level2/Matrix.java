package com.freend.algorithm.programers.level2;

public class Matrix {
    public int[][] multipleMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] answer = new int[firstMatrix.length][secondMatrix[0].length];
        int firstItem;
        int secondItem;
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                int totalItem = 0;
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    firstItem = firstMatrix[i][k];
                    secondItem = secondMatrix[k][j];
                    totalItem += firstItem * secondItem;
                }
                answer[i][j] = totalItem;
            }
        }
        return answer;
    }
}
