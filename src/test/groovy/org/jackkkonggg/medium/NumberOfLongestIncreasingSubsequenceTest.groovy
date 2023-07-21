package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification


/**
 * @author: Jack Ong
 * @date: 2023/07/21 09:53
 */
class NumberOfLongestIncreasingSubsequenceTest extends Specification {
    @Shared
    NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence()

    def "example test"() {
        expect:
        numberOfLongestIncreasingSubsequence.findNumberOfLIS(nums as int[]) == result

        where:
        nums            | result
        [1, 3, 5, 4, 7] | 2
        [2, 2, 2, 2, 2] | 5
    }
}
