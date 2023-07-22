package org.jackkkonggg.easy;

import java.util.Arrays;

public class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();
        long distinctCount = Arrays.stream(nums).distinct().count();
        return distinctCount == max && sum == (max * (max + 1)) / 2 + max;
    }
}
