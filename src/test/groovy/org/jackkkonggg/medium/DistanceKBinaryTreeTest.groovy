package org.jackkkonggg.medium

import org.jackkkonggg.structure.TreeNode
import spock.lang.Shared
import spock.lang.Specification

class DistanceKBinaryTreeTest extends Specification {
    @Shared
    def distanceKCalculator = new DistanceKBinaryTree()

    def "should work"() {
        expect:
        distanceKCalculator.distanceK(root, target, distance) == output

        where:
        root                                                       | target          | distance | output
        TreeNode.fromList([3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]) | new TreeNode(5) | 2        | [1, 4, 7]
        TreeNode.fromList([1])                                     | new TreeNode(1) | 3        | []
    }
}
