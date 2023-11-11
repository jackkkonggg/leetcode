package org.jackkkonggg.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfHomogeneousSubstrings {
    public static int MODULO = (int) 1e9 + 7;

    public int solve(String s) {
        int count = 0;
        // key: contiguous string length
        // value: number of times it occurred
        Map<Integer, Integer> contiguousOccurrences = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                int length = r++ - l + 1;
                contiguousOccurrences.put(length, contiguousOccurrences.getOrDefault(length, 0) + 1);
                contiguousOccurrences.put(length - 1, contiguousOccurrences.getOrDefault(length - 1, 0) - 1);
            } else {
                l = r;
            }
        }

        System.out.println(contiguousOccurrences);

        for (Map.Entry<Integer, Integer> entry : contiguousOccurrences.entrySet()) {
            int totalPossibilities = getPossibilities(entry.getKey()) * entry.getValue();
            count += totalPossibilities;
            count %= MODULO;
        }

        return count;
    }

    public int getPossibilities(int n) {
        return (n * (n + 1)) / 2;
    }
}
