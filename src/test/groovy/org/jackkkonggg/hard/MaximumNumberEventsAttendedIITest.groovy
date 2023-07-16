package org.jackkkonggg.hard

import spock.lang.Shared
import spock.lang.Specification

class MaximumNumberEventsAttendedIITest extends Specification {
    @Shared
    def maximumNumberEventsAttendedII = new MaximumNumberEventsAttendedII()

    def "example test"() {
        expect:
        maximumNumberEventsAttendedII.maxValue(events as int[][], k) == result
        where:
        events                            | k | result
        [[1, 2, 4], [3, 4, 3], [2, 3, 1]] | 2 | 7
    }
}
