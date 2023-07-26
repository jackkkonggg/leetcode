package org.jackkkonggg.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author: Jack Ong
 * @date: 2023/07/26 20:18
 */
public class MinimumSpeedToArriveOnTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int sum = Arrays.stream(dist).sum(), length = dist.length, minSpeed = -1;
        int lowerBound = (int) Math.floor(sum / hour), upperBound = (int) 1e7;
        
        while (lowerBound <= upperBound) {
            int currentSpeed = lowerBound + (upperBound - lowerBound) / 2;
            double timeTaken =
                    IntStream.range(0, length - 1)
                            .map(index -> (int) Math.ceil((double) dist[index] / currentSpeed))
                            .sum()
                            + (double) dist[length - 1] / currentSpeed;
            
            if (timeTaken <= hour) {
                minSpeed = currentSpeed;
                upperBound = currentSpeed - 1;
            } else {
                lowerBound = currentSpeed + 1;
            }
        }
        
        return minSpeed;
    }
}
