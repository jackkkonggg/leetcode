package org.jackkkonggg.easy

import org.jackkkonggg.structure.TreeNode
import spock.lang.Shared
import spock.lang.Specification

class MinDepthTest extends Specification {
    @Shared
    def minDepth = new MinDepth()

    def "example tests"() {
        expect:
        depth == minDepth.solve(root)

        where:
        root                                                       | depth
        TreeNode.fromList([3, 9, 20, null, null, 15, 7])           | 2
        TreeNode.fromList([2, null, 3, null, 4, null, 5, null, 6]) | 5
    }

}
