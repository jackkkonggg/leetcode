package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class KnightProbabilityInChessBoardTest extends Specification {
    @Shared
    KnightProbabilityInChessBoard knightProbabilityInChessBoard = new KnightProbabilityInChessBoard()

    def "example tests"() {
        expect:
        knightProbabilityInChessBoard.knightProbability(n, k, row, column) == result as double

        where:
        n | k | row | column | result
        3 | 2 | 0   | 0      | 0.0625
        1 | 0 | 0   | 0      | 1
    }
}

