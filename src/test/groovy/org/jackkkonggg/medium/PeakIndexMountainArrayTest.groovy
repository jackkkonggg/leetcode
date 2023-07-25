package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class PeakIndexMountainArrayTest extends Specification {
    @Shared
    PeakIndexMountainArray peakIndexMountainArray = new PeakIndexMountainArray()

    def "example test"() {
        expect:
        peakIndexMountainArray.peakIndexInMountainArray(arr as int[]) == index

        where:
        arr           | index
        [0, 1, 0]     | 1
        [0, 2, 1, 0]  | 1
        [0, 10, 5, 2] | 1
    }

}
