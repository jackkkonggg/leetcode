package org.jackkkonggg.structure;

import java.util.*;

/**
 * @author: Jack Ong
 * @date: 2023/07/13 22:54
 */
public class AdjacencyList<T> {
  private final Map<T, List<T>> adjList;

  public AdjacencyList(Map<T, List<T>> adjList) {
    this.adjList = adjList;
  }

  public static <T> AdjacencyList<T> fromDirectedEdges(List<List<T>> edges, boolean rightToLeft) {
    Map<T, List<T>> adjL = new HashMap<>();
    edges.forEach(
        edge -> {
          if (edge.size() != 2)
            throw new IllegalArgumentException("Expected edge to have length 2");
          T u = edge.get(0), v = edge.get(1);
          if (rightToLeft) {
              u = edge.get(1);
              v = edge.get(0);
          }
          adjL.computeIfAbsent(u, node -> new ArrayList<>());
          adjL.computeIfAbsent(v, node -> new ArrayList<>());
          adjL.get(u).add(v);
        });

    return new AdjacencyList<>(adjL);
  }

    public static <T> AdjacencyList<T> fromDirectedEdges(List<List<T>> edges) {
      return AdjacencyList.fromDirectedEdges(edges, false);
    }

  public Map<T, List<T>> getAdjList() {
    return adjList;
  }
}
