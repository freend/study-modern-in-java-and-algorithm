package com.freend.algorithm.programers;

public class Day2016 {
    String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int[] monthly = new int[12];
    int month;
    int date;
    public String solution(int a, int b) {
        this.month = a;
        this.date = b;
        createCalendar();
        return days[getUpdateMonthlyDays() % 7];
    }

    private int getUpdateMonthlyDays() {
        int monthlyDayTotal = 0;
        for (int i = 0; i < this.month; i++) {
            monthlyDayTotal += monthly[i];
        }
        return monthlyDayTotal + this.date;
    }

    private void createCalendar() {
        for (int i = 1; i < this.monthly.length; i++) {
            if (i <= 7 && i % 2 == 1) {
                this.monthly[i] = 31;
            } else if (i >= 8 && i % 2 == 0) {
                this.monthly[i] = 31;
            } else {
                this.monthly[i] = 30;
            }
        }
        this.monthly[2] = 29;
    }
}
