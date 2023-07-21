package org.jackkkonggg.medium;

import java.util.Arrays;

/**
 * @author: Jack Ong
 * @date: 2023/07/21 09:48
 */
public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n], count = new int[n];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }

        int maxLength = Arrays.stream(length).max().getAsInt();
        int result = 0;
        for (int i = 0; i < n; ++i) if (length[i] == maxLength) result += count[i];

        return result;
    }
}
