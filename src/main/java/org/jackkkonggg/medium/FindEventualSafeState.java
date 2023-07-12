package org.jackkkonggg.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: Jack Ong
 * @date: 2023/07/12 11:14
 */


public class FindEventualSafeState {
    private int numNodes;
    private List<List<Integer>> outgoing;
    private List<ArrayList<Integer>> incoming;

    /**
     * @param graph directed adjacency list
     *              example: [[1,2],[2,3],[5],[0],[5],[],[]]
     * @return returns safe nodes in the graph, sorted in ascending order
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        numNodes = graph.length;
        outgoing = Arrays.stream(graph)
                         .map(outgoingEdges -> Arrays.stream(outgoingEdges).boxed().toList())
                         .toList();
        incoming = Arrays.stream(graph).map(edges -> new ArrayList<Integer>()).toList();
        IntStream.range(0, numNodes)
                 .boxed()
                 .forEach(u -> outgoing.get(u).forEach(v -> incoming.get(v).add(u)));

        List<Integer> terminalNodes = IntStream.range(0, numNodes)
                                               .boxed()
                                               .filter(i -> graph[i].length == 0)
                                               .toList();
        System.out.println(outgoing);
        System.out.println(incoming);
        System.out.println(terminalNodes);
        return null;
    }
}
