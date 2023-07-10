package org.jackkkonggg.structure;


import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Sample Input: [3,9,20,null,null,15,7]
    public static TreeNode fromList(List<Integer> preorder) {
        if (preorder.size() == 0) return null;

        TreeNode root = new TreeNode(preorder.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>(Collections.singletonList(root));

        Branch side = Branch.Left;
        for (int i = 1; i < preorder.size(); ++i) {
            TreeNode front = queue.peek();
            if (front == null) throw new IllegalStateException();

            Integer val = preorder.get(i);
            if (side == Branch.Left) {
                if (val != null) {
                    front.left = new TreeNode(val);
                    queue.add(front.left);
                }
                side = Branch.Right;
            } else {
                if (val != null) {
                    front.right = new TreeNode(val);
                    queue.add(front.right);
                }

                queue.poll();
                side = Branch.Left;
            }
        }

        return root;
    }

    private enum Branch {
        Left,
        Right
    }
}
