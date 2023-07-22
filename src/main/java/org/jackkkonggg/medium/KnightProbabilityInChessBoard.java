package org.jackkkonggg.medium;

import java.util.HashMap;
import java.util.Map;

public class KnightProbabilityInChessBoard {
    public static int[][] DIR = {
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };
    private final Map<String, Double> mp = new HashMap<>();
    
    /**
     * @param n n by n chessboard
     * @param k number of moves
     * @param row y-position
     * @param column x-position
     * @return probability that the knight remains on the board after it has stopped moving
     */
    public double knightProbability(int n, int k, int row, int column) {
        return find(n, k, row, column);
    }
    
    private double find(int n, int moves, int r, int c) {
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        if (moves == 0) return 1;
        
        String key = String.format("%dx %dy %dm", c, r, moves);
        if (mp.containsKey(key))
            return mp.get(key);
        
        double probability = 0;
        for (int i = 0; i < 8; ++i)
            probability += find(n, moves - 1, r + DIR[i][0], c + DIR[i][1]) / 8;
        
        mp.put(key, probability);
        return probability;
    }
}
