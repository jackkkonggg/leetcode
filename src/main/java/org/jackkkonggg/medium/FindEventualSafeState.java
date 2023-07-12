package org.jackkkonggg.medium;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author: Jack Ong
 * @date: 2023/07/12 11:14
 */
public class FindEventualSafeState {

  /**
   * @param graph directed adjacency list example: [[1,2],[2,3],[5],[0],[5],[],[]]
   * @return returns safe nodes in the graph, sorted in ascending order
   */
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    Map<Integer, Integer> indegree = new HashMap<>();
    IntStream.range(0, n).boxed().forEach(i -> indegree.merge(i, graph[i].length, Integer::sum));

    List<ArrayList<Integer>> adj =
        IntStream.range(0, n).boxed().map(i -> new ArrayList<Integer>()).toList();

    IntStream.range(0, n)
        .boxed()
        .forEach(i -> Arrays.stream(graph[i]).forEach(node -> adj.get(node).add(i)));

    Queue<Integer> queue = new ArrayDeque<>();
    IntStream.range(0, n).boxed().filter(i -> indegree.getOrDefault(i, 0) == 0).forEach(queue::add);

    List<Boolean> safe = new ArrayList<>(IntStream.range(0, n).boxed().map(i -> false).toList());
    while (!queue.isEmpty()) {
      int node = queue.poll();
      safe.set(node, true);
      adj.get(node)
          .forEach(
              neighbor -> {
                indegree.merge(neighbor, -1, Integer::sum);
                if (indegree.getOrDefault(neighbor, 0) == 0) queue.add(neighbor);
              });
    }

    return IntStream.range(0, n).boxed().filter(safe::get).toList();
  }
}
