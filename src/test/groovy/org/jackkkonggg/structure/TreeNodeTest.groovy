package org.jackkkonggg.structure

import spock.lang.Specification

class TreeNodeTest extends Specification {
    def "fromList should work with [3,9,20,null,null,15,7]"() {
        given:
        List<Integer> preorder = [3,9,20,null,null,15,7]
        TreeNode root = TreeNode.fromList(preorder)

        expect:
        root.val == 3
        root.left.val == 9
        root.right.val == 20
        root.left.left == null
        root.left.right == null
        root.right.left.val == 15
        root.right.right.val == 7
    }
}
