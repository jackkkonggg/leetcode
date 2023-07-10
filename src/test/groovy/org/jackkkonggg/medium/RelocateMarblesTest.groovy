package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class RelocateMarblesTest extends Specification {
    @Shared
    def marblesRelocator = new RelocateMarbles()

    def "should work"() {
        expect:
        int[] castedNums = nums
        int[] castedMoveFrom = moveFrom
        int[] castedMoveTo = moveTo
        marblesRelocator.relocateMarbles(castedNums, castedMoveFrom, castedMoveTo) == finalPositions

        where:
        nums         | moveFrom                    | moveTo                      | finalPositions
        [1, 6, 7, 8] | [1, 7, 2]                   | [2, 9, 5]                   | [5, 6, 8, 9]
        [1, 1, 3, 3] | [1, 3]                      | [2, 2]                      | [2]
        [3, 4]       | [4, 3, 1, 2, 2, 3, 2, 4, 1] | [3, 1, 2, 2, 3, 2, 4, 1, 1] | [1]
    }
}
