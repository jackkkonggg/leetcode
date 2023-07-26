package org.jackkkonggg.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: Jack Ong
 * @date: 2023/07/26 20:18
 */
public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) return -1;
        int sum = Arrays.stream(dist).sum();
        double startingSpeed = Math.ceil(sum / hour);

        int length = dist.length;
        while (true) {
            double finalStartingSpeed = startingSpeed;
            double timeTaken =
                    IntStream.range(0, length - 1)
                            .map(index -> (int) Math.ceil(dist[index] / finalStartingSpeed))
                            .sum()
                            + dist[length - 1] / startingSpeed;

            if (timeTaken <= hour) return (int) startingSpeed;
            else startingSpeed += 1;
        }
    }
}
