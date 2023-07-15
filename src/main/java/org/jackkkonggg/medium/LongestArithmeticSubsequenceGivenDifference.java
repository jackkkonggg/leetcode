package org.jackkkonggg.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author: Jack Ong
 * @date: 2023/07/15 01:47
 */
public class LongestArithmeticSubsequenceGivenDifference {
  public int longestSubsequence(int[] arr, int difference) {
    int n = arr.length;
    Map<Integer, List<Integer>> positions = new HashMap<>();
    IntStream.range(0, n)
        .boxed()
        .forEach(
            i -> {
              int num = arr[i];
              positions.putIfAbsent(num, new ArrayList<>());
              positions.get(num).add(i);
            });

    List<Integer> dp = IntStream.range(0, n).boxed().map(i -> 1).collect(Collectors.toList());
    for (int i = 0; i < n; ++i) {
      int element = arr[i];
      List<Integer> counterparts = positions.get(element - difference);
      if (counterparts == null) continue;

      for (int j = counterparts.size() - 1; j >= 0; --j) {
        int counterpartIndex = counterparts.get(j);
        if (counterpartIndex < i) {
          dp.set(i, dp.get(i) + dp.get(counterpartIndex));
          break;
        }
      }
    }

    return dp.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE);
  }
}
