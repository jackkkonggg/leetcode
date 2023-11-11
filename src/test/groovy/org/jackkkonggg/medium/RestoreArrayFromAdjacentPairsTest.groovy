package org.jackkkonggg.medium

import spock.lang.Specification

class RestoreArrayFromAdjacentPairsTest extends Specification {
    def "example tests"() {
        expect:
        RestoreArrayFromAdjacentPairs restoreArrayFromAdjacentPairs = new RestoreArrayFromAdjacentPairs()
        restoreArrayFromAdjacentPairs.restoreArray(pairs as int[][]) == result as int[]

        where:
        pairs                      | result
        [[2, 1], [3, 4], [3, 2]]   | [1, 2, 3, 4]
        [[4, -2], [1, 4], [-3, 1]] | [-2, 4, 1, -3]
    }
}
