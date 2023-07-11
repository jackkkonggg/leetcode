package org.jackkkonggg.medium;

import org.jackkkonggg.structure.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">LeetCode</a>
 */
public class DistanceKBinaryTree {
    private final HashSet<Integer> visited = new HashSet<>();
    private final Queue<Integer> queue = new ArrayDeque<>();
    private final HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null || target == null) return Collections.emptyList();

        this.buildAdjacencyList(root);

        int targetValue = target.val, currentDistance = 0;
        visited.add(targetValue);
        queue.add(targetValue);
        while (currentDistance < k && !queue.isEmpty()) {
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; ++i) {
                List<Integer> neighbors = adjacencyList.get(queue.poll());
                if (neighbors == null) continue;

                for (int val : neighbors) {
                    if (visited.contains(val)) continue;
                    visited.add(val);
                    queue.add(val);
                }
            }

            ++currentDistance;
        }

        return queue.stream().sorted().toList();
    }

    private void buildAdjacencyList(TreeNode root) {
        if (root == null) return;

        int u = root.val;
        if (root.left != null) addEdge(u, root.left.val);
        if (root.right != null) addEdge(u, root.right.val);

        this.buildAdjacencyList(root.left);
        this.buildAdjacencyList(root.right);
    }

    private void addEdge(int u, int v) {
        adjacencyList.merge(u, List.of(v), (currentList, incomingList) -> {
            List<Integer> currentListCopy = new ArrayList<>(currentList);
            currentListCopy.addAll(incomingList);
            return currentListCopy;
        });
        adjacencyList.merge(v, List.of(u), (currentList, incomingList) -> {
            List<Integer> currentListCopy = new ArrayList<>(currentList);
            currentListCopy.addAll(incomingList);
            return currentListCopy;
        });
    }
}
