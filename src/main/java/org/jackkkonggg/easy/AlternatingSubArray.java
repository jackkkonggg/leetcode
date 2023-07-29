package org.jackkkonggg.easy;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-alternating-subarray/">LeetCode</a>
 */
public class AlternatingSubArray {
    public int solve(int[] nums) {
        if (nums.length < 2) throw new IllegalArgumentException("Expected nums to have length >= 2");

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 2; ++i) hashSet.add(nums[i]);

        int left = 0, right = 1, maxLength = Integer.MIN_VALUE;
        while (right < nums.length - 1) {
            hashSet.add(nums[++right]);
            if (hashSet.size() > 2) hashSet.remove(nums[left++]);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
