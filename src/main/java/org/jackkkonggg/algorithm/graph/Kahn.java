package org.jackkkonggg.algorithm.graph;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jackkkonggg.structure.AdjacencyList;

/**
 * @author: Jack Ong
 * @date: 2023/07/13 22:53
 */
public class Kahn {
  public static <T> Map<T, Integer> findInDegree(Map<T, List<T>> graph) {
    Map<T, Integer> inDegree =
        graph.keySet().stream().collect(Collectors.toMap(Function.identity(), v -> 0));

    // Loop through every node and add 1 in-edge count to its neighbors
    graph.forEach(
        (key, value) -> value.forEach(neighbor -> inDegree.merge(neighbor, 1, Integer::sum)));

    return inDegree;
  }

  public static <T> List<T> topologicalSort(Map<T, List<T>> graph) {
    List<T> res = new ArrayList<>();
    Map<T, Integer> inDegree = findInDegree(graph);
    Queue<T> queue =
        inDegree.entrySet().stream()
            .filter(entry -> entry.getValue() == 0)
            .map(Map.Entry::getKey)
            .collect(Collectors.toCollection(ArrayDeque::new));

    inDegree.entrySet().forEach(System.out::println);
    System.out.println(queue);

    while (!queue.isEmpty()) {
      T node = queue.poll();
      res.add(node);
      graph
          .get(node)
          .forEach(
              neighbor -> {
                inDegree.merge(neighbor, -1, Integer::sum);
                if (inDegree.get(neighbor) == 0) queue.add(neighbor);
              });
    }

    return graph.size() == res.size() ? res : null;
  }

  public static <T> List<T> topologicalSort(AdjacencyList<T> adjacencyList) {
    return Kahn.topologicalSort(adjacencyList.getAdjList());
  }
}
