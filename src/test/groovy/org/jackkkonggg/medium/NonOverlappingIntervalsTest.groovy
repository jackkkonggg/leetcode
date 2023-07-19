package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class NonOverlappingIntervalsTest extends Specification {
    @Shared
    NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals()

    def "example tests"() {
        expect:
        nonOverlappingIntervals.eraseOverlapIntervals(intervals as int[][]) == result

        where:
        intervals                        | result
        [[1, 2], [2, 3], [3, 4], [1, 3]] | 1
        [[1, 2], [1, 2], [1, 2]]         | 2
        [[1, 2], [2, 3]]                 | 0
    }
}
