package com.jw.task2;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalMerger {

    /**
     * Merges the intersecting intervals.
     * Time complexity is: O(n * log(n) + n), when using heap sort.
     */
    public void merge(int[][] intervals) {
        if (intervals.length < 2)
            return;
        sort(intervals);
        int[] prev = intervals[0];
        int prevPos = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur == null)
                continue;
            assert cur[0] <= cur[1];
            if (prev[1] < cur[1]) {
                if (prev[1] >= cur[0]) {
                    prev[1] = cur[1];
                } else {
                    prev = cur;
                    intervals[prevPos++] = prev;
                }
            }
        }
        for (int i = prevPos; i < intervals.length; i++) {
            intervals[i] = null;
        }
    }

    /**
     * Assuming Java uses QuickSort for arrays, the worst case is O(n^2), while space complexity is O(log(n));
     * Using HeapSort would decrease time complexity to O(n log(n)) and space complexity to O(1).
     */
    private void sort(int[][] intervals) {
        // quickSort(intervals);
        heapSort(intervals);
    }

    private void quickSort(int[][] arr) {
        Arrays.sort(arr, Comparator.comparing(item -> item[0]));
    }

    private void heapSort(int[][] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int[] temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[][] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (arr[largest] != null) {
            if (l < n && arr[l] != null && arr[l][0] > arr[largest][0])
                largest = l;
            if (r < n && arr[r] != null && arr[r][0] > arr[largest][0])
                largest = r;
        }

        if (largest != i) {
            int[] swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

}
