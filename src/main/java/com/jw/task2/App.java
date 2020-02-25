package com.jw.task2;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        IntervalMerger merger = new IntervalMerger();

        int[][] intervals1 = {
                {1, 4},
                {3, 7},
                {8, 10},
                {9, 11}
        };

        int[][] intervals2 = {
                {2, 4},
                {4, 6},
                {7, 9}
        };

        merger.merge(intervals1);
        System.out.println(Arrays.deepToString(intervals1)); // [ 1, 7 ], [ 8, 11 ], null, null

        merger.merge(intervals2);
        System.out.println(Arrays.deepToString(intervals2)); // [ 2, 6 ], [ 7, 9 ], null

    }

}
