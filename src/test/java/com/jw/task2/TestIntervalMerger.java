package com.jw.task2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestIntervalMerger {

    static IntervalMerger merger;

    @BeforeClass
    public static void prepare() {
        merger = new IntervalMerger();
    }

    @Test
    public void testMergeGeneric() {

        int[][] intervals = {
                {1, 5},
                {12, 15},
                {8, 9},
                {1, 4},
                {10, 15},
                {3, 7},
                null,
                {1, 3},
                {100, 100},
                {1, 1},
                {5, 9},
                {1, 2}
        };

        int[][] expected = {
                {1, 9},
                {10, 15},
                {100, 100},
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        };

        merger.merge(intervals);
        assertArrayEquals(expected, intervals);
    }

    @Test
    public void testMergeNulls() {

        int[][] intervals = {
                null,
                null,
                null,
                null
        };

        int[][] expected = {
                null,
                null,
                null,
                null
        };

        merger.merge(intervals);
        assertArrayEquals(expected, intervals);
    }

    @Test
    public void testMergeSameIntervals() {

        int[][] intervals = {
                {4, 20},
                {4, 20},
                {4, 20},
                {4, 20}
        };

        int[][] expected = {
                {4, 20},
                null,
                null,
                null
        };

        merger.merge(intervals);
        assertArrayEquals(expected, intervals);

    }

    @Test
    public void testMergeSingleInterval() {

        int[][] intervals = {
                {1, 2}
        };

        int[][] expected = {
                {1, 2}
        };

        merger.merge(intervals);
        assertArrayEquals(expected, intervals);

    }

}