package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification


/**
 * @author: Jack Ong
 * @date: 2023/07/15 11:18
 */
class LongestArithmeticSubsequenceGivenDifferenceTest extends Specification {
    @Shared
    LongestArithmeticSubsequenceGivenDifference longestArithmeticSubsequenceGivenDifference = new LongestArithmeticSubsequenceGivenDifference()

    def "example test"() {
        expect:
        longestArithmeticSubsequenceGivenDifference.longestSubsequence(arr as int[], difference) == result

        where:
        arr                         | difference | result
        [1, 2, 3, 4]                | 1          | 4
        [1, 3, 5, 7]                | 1          | 1
        [1, 5, 7, 8, 5, 3, 4, 2, 1] | -2         | 4
        [3, 4, -3, -2, -4]          | -5         | 2
    }
}
