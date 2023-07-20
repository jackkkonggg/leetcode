package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class AsteriodCollisionTest extends Specification {
    @Shared
    AsteriodCollision asteriodCollision = new AsteriodCollision()

    def "example test"() {
        expect:
        asteriodCollision.asteroidCollision(asteriods as int[]) == result as int[]

        where:
        asteriods   | result
        [5, 10, -5] | [5, 10]
        [8, -8]     | []
        [10, 2, -5] | [10]
    }
}
