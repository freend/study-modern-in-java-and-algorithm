package com.freend.algorithm.programers;

public class BinaryMap {
    private int arrLength;
    public String[] binaryMap(int n, int[] firstArr, int[] secondArr) {
        this.arrLength = firstArr.length;
        String[] answer = new String[this.arrLength];
        for (int i = 0; i < firstArr.length; i++) {
            String mergeBinary = this.changeBinary(firstArr[i], secondArr[i]);
            answer[i] = this.marchString(mergeBinary);
        }
        System.out.println("checker");
        return answer;
    }
    private String marchString(String mergeString) {
        mergeString = mergeString.replaceAll("1", "#");
        mergeString = mergeString.replaceAll("0", " ");
        return mergeString;
    }
    private String changeBinary(int firstNum, int secondNum) {
        return String.format("%" + this.arrLength + "s", Integer.toBinaryString(firstNum | secondNum));
    }
    /**
     * 내가 만든 소스 .. 다른사람의 풀이를 보고 지울까 했지만.... 그냥 놔뒀다 더 공부해야 할 이유를 보여준다.
     */

    public String[] beforeBinaryMap(int n, int[] firstArr, int[] secondArr) {
        this.arrLength = firstArr.length;
        String[] answer = new String[this.arrLength];
        for (int i = 0; i < firstArr.length; i++) {
            String firstBinary = this.changeBinary(firstArr[i]);
            String secondBinary = this.changeBinary(secondArr[i]);
            answer[i] = this.mergeLine(firstBinary, secondBinary);
        }
        System.out.println("checker");
        return answer;
    }
    private String mergeLine(String firstLine, String secondLine) {
        int length = firstLine.length();
        String result = "";
        for (int i = 0; i < length; i++) {
            if (String.valueOf(firstLine.charAt(i)).equals("0") && String.valueOf(secondLine.charAt(i)).equals("0")) {
                result += " ";
            } else {
                result += "#";
            }
        }
        return result;
    }
    private String changeBinary(int num) {
        String resultStr = "";
        String binaryStr = Integer.toBinaryString(num);
        int gapLen = arrLength - binaryStr.length();
        for (int i = 0; i < gapLen; i++) {
            resultStr += "0";
        }
        resultStr += binaryStr;
        return resultStr;
    }
}
