package org.jackkkonggg.easy

import spock.lang.Shared
import spock.lang.Specification

class AlternatingSubArrayTest extends Specification {
    @Shared
    def alternatingSubArray = new AlternatingSubArray()

    def "should throw an exception when the input does not have the required length"() {
        when:
        int[] nums = []
        alternatingSubArray.solve(nums)

        then:
        thrown(IllegalArgumentException)
    }

    def "example tests"() {
        expect:
        maxLength == alternatingSubArray.solve(nums as int[])

        where:
        nums            | maxLength
        [2, 3, 4, 3, 4] | 4
        [4, 5, 6]       | 2
    }
}
