package org.jackkkonggg.hard

import spock.lang.Shared
import spock.lang.Specification

class MaximumRunningTimeOfNComputersTest extends Specification {
    @Shared
    MaximumRunningTimeOfNComputers maximumRunningTimeOfNComputers = new MaximumRunningTimeOfNComputers()

    def "example tests"() {
        expect: true
        maximumRunningTimeOfNComputers.maxRunTime(n, batteries as int[]) == result

        where:
        n | batteries    | result
        2 | [3, 3, 3]    | 4
        2 | [1, 1, 1, 1] | 2
    }
}
