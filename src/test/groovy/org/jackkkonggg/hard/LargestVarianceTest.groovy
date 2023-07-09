package org.jackkkonggg.hard

import spock.lang.Shared
import spock.lang.Specification

class LargestVarianceTest extends Specification {
    @Shared
    def largestVariance = new LargestVariance()

    def "exceptions"() {
        when:
        String s = ""
        largestVariance.solve(s)

        then:
        thrown(IllegalArgumentException)
    }


    def "example tests"() {
        expect:
        maxVariance == largestVariance.solve(s)

        where:
        s         | maxVariance
        "aabbabb" | 3
        "abcde"   | 0
    }
}
