package org.jackkkonggg.easy

import spock.lang.Shared
import spock.lang.Specification

class CheckIfArrayIsGoodTest extends Specification {
    @Shared
    CheckIfArrayIsGood checkIfArrayIsGood = new CheckIfArrayIsGood()

    def "example test"() {
        expect:
        checkIfArrayIsGood.isGood(nums as int[]) == result

        where:
        nums               | result
        [2, 1, 3]          | false
        [1, 3, 3, 2]       | true
        [1, 1]             | true
        [3, 4, 4, 1, 2, 1] | false
        [2, 4, 4, 4]       | false
    }
}
