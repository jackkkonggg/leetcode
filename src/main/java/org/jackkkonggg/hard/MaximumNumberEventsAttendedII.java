package org.jackkkonggg.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberEventsAttendedII {
  public int maxValue(int[][] events, int k) {
    Arrays.sort(events, Comparator.comparingDouble(o -> o[0]));
    int[][] dp = new int[k + 1][events.length + 1];
    return helper(events, k, 0, dp);
  }

  int helper(int[][] events, int k, int i, int[][] dp) {
    if (i >= events.length || k <= 0) return 0;
    if (dp[k][i] != 0) return dp[k][i];
    int skip = helper(events, k, i + 1, dp);
    int val = events[i][2];
    int j = i + 1;
    for (; j < events.length; j++) {
      if (events[j][0] > events[i][1]) break;
    }
    int take = val + helper(events, k - 1, j, dp);
    return dp[k][i] = Math.max(skip, take);
  }
}
