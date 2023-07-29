package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class SoupServingsTest extends Specification {
    @Shared
    SoupServings servings = new SoupServings()

    def "example tests"() {
        expect:
        servings.soupServings(n) == result as double

        where:
        n   | result
        50  | 0.625
        100 | 0.71875
    }
}
