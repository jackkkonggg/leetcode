package org.jackkkonggg.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int prev = 0, count = 1;
        for (int i = count; i < n; ++i) {

            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                ++count;
            }
        }

        return n - count;
    }
}
