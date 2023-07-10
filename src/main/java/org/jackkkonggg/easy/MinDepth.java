package org.jackkkonggg.easy;

import org.jackkkonggg.structure.TreeNode;

public class MinDepth {
    public int solve(TreeNode root) {
        if (root == null) return 0;

        int depthL = this.solve(root.left), depthR = this.solve(root.right);
        boolean doubleChildren = depthL != 0 && depthR != 0;
        return doubleChildren ? 1 + Math.min(depthL, depthR) : 1 + Math.max(depthL, depthR);
    }
}
