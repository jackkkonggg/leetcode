package org.jackkkonggg.hard

import spock.lang.Shared
import spock.lang.Specification

class StrangerPrinterTest extends Specification {
    @Shared
    StrangerPrinter strangerPrinter = new StrangerPrinter()

    def "example tests"() {
        expect:
        strangerPrinter.strangePrinter(s) == result

        where:
        s        | result
        "aaabbb" | 2
        "aba"    | 2
    }
}
