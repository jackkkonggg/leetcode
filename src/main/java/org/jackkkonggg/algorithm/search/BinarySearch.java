package org.jackkkonggg.algorithm.search;

import java.util.List;

public class BinarySearch {
  public static <T extends Integer> int search(List<T> list, T target) {
    int left = 0, right = list.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      int comparisonResult = list.get(mid).compareTo(target);
      if (comparisonResult == 0) return mid;
      if (comparisonResult < 0) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }
}
