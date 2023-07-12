package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification


/**
 * @author: Jack Ong
 * @date: 2023/07/12 11:18
 */
class FindEventualSafeStateTest extends Specification {
    @Shared
    def safeStateFinder = new FindEventualSafeState()

    def "should work with example input"() {
        expect:
        safeStateFinder.eventualSafeNodes(graph as int[][]) == output

        where:
        graph                                      | output
        [[1, 2], [2, 3], [5], [0], [5], [], []]    | [2, 4, 5, 6]
        [[1, 2, 3, 4], [1, 2], [3, 4], [0, 4], []] | [4]
    }
}
