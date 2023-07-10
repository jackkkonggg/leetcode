package org.jackkkonggg.medium;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/relocate-marbles/solutions/">LeetCode</a>
 */
public class RelocateMarbles {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        if (moveFrom.length != moveTo.length)
            throw new IllegalArgumentException();

        Map<Integer, Integer> map = Arrays.stream(nums)
                                          .boxed()
                                          .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        int moveLength = moveFrom.length;
        IntStream.range(0, moveLength)
                 .mapToObj(i -> Arrays.asList(moveFrom[i], moveTo[i]))
                 .forEach(integers -> {
                     int src = integers.get(0), dest = integers.get(1);
                     if (src != dest) {
                         int numMarbles = map.getOrDefault(src, 0);
                         map.merge(dest, numMarbles, Integer::sum);
                         map.remove(src);
                     }
                 });

        return map.keySet()
                  .stream()
                  .sorted()
                  .toList();
    }
}
