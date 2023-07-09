package org.jackkkonggg.hard;

import java.util.HashSet;
import java.util.stream.Collectors;

public class LargestVariance {
    public int solve(String s) {
        int count1, count2, maxVariance = 0;
        HashSet<Character> distinctChars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toCollection(HashSet::new));


        for (int runs = 0; runs < 2; ++runs) {
            for (char l1 : distinctChars) {
                for (char l2 : distinctChars) {
                    if (l1 == l2) continue;
                    count1 = count2 = 0;
                    for (char letter : s.toCharArray()) {
                        if (letter == l1) ++count1;
                        else if (letter == l2) ++ count2;

                        if (count1 < count2) count1 = count2 = 0;
                        else if (count1 > 0 && count2 > 0) maxVariance = Math.max(maxVariance, count1 - count2);
                    }

                }
            }

            // Reverse the string for the second time around
            s = new StringBuilder(s).reverse().toString();
        }

        return maxVariance;
    }
}
