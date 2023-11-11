package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class CountNumberOfHomogeneousSubstringsTest extends Specification {
    @Shared
    CountNumberOfHomogeneousSubstrings countNumberOfHomogeneousSubstrings = new CountNumberOfHomogeneousSubstrings()

    def "example tests"() {
        expect:
        countNumberOfHomogeneousSubstrings.solve(s) == result

        where:
        s          | result
        "abbcccaa" | 13
        "a"        | 1
        "xy"       | 2
    }
}
