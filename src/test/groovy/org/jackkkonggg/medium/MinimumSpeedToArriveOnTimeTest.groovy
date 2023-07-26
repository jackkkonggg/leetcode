package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification


/**
 * @author: Jack Ong
 * @date: 2023/07/26 20:22
 */
class MinimumSpeedToArriveOnTimeTest extends Specification {
    @Shared
    MinimumSpeedToArriveOnTime minimumSpeedToArriveOnTime = new MinimumSpeedToArriveOnTime()

    def "example tests"() {
        expect:
        minimumSpeedToArriveOnTime.minSpeedOnTime(dist as int[], hour as double) == result

        where:
        dist      | hour | result
        [1, 3, 2] | 6    | 1
        [1, 3, 2] | 2.7  | 3
        [1, 3, 2] | 1.9  | -1
//        [1, 3, 2] | 2.01 | 3
    }
}
