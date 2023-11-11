package org.jackkkonggg.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestoreArrayFromAdjacentPairs {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    
    /**
    *
     * @param adjacentPairs [[2,1],[3,4],[3,2]]
    */
    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] pair : adjacentPairs) {
            int u = pair[0], v = pair[1];
            addToAdjacencyList(u, v);
            addToAdjacencyList(v, u);
        }
        
        Map.Entry<Integer, List<Integer>> start = adjacencyList.entrySet().stream().filter(entry -> entry.getValue().size() == 1).findFirst().get();
        Integer currentValue = start.getKey(), previousValue = null;
        List<Integer> result = new ArrayList<>();
        while (true) {
            result.add(currentValue);
            List<Integer> nodes = adjacencyList.get(currentValue);
            Integer finalPreviousValue = previousValue;
            
            Optional<Integer> nextValueOpt = nodes.stream()
                    .filter(v -> !v.equals(finalPreviousValue))
                    .findFirst();
            if (nextValueOpt.isEmpty()) break;
            
            previousValue = currentValue;
            currentValue = nextValueOpt.get();
        }
        

        System.out.println(adjacencyList);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void addToAdjacencyList(int src, int dsc) {
        if (adjacencyList.containsKey(src)) {
            adjacencyList.get(src).add(dsc);
        } else {
            adjacencyList.put(src, Stream.of(dsc).collect(Collectors.toList()));
        }
    }
}
