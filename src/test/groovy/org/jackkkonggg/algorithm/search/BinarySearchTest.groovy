package org.jackkkonggg.algorithm.search

import spock.lang.Specification

class BinarySearchTest extends Specification {
    def "should search successfully"() {
        expect:
        BinarySearch.search(list, target) == result

        where:
        list                | target | result
        [1, 3, 6, 8, 9, 10] | 9      | 4
        [1, 3, 6, 8, 9, 10] | 5      | -1
    }
}
