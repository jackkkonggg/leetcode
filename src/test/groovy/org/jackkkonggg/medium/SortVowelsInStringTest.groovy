package org.jackkkonggg.medium

import spock.lang.Shared
import spock.lang.Specification

class SortVowelsInStringTest extends Specification {
    @Shared
    SortVowelsInString sortVowelsInString = new SortVowelsInString()

    def "example tests"() {
        expect:
        sortVowelsInString.sortVowels(s) == result

        where:
        s          | result
        "lEetcOde" | "lEOtcede"
        "lYmpH"    | "lYmpH"
    }
}
