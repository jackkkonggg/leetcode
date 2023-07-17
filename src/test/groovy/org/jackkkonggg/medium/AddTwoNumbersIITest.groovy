package org.jackkkonggg.medium

import org.jackkkonggg.structure.ListNode
import spock.lang.Shared
import spock.lang.Specification


/**
 * @author: Jack Ong
 * @date: 2023/07/17 09:26
 */
class AddTwoNumbersIITest extends Specification {
    @Shared
    def addTwoNumbersII = new AddTwoNumbersII()

    def "example tests"() {
        expect:
        ListNode result = addTwoNumbersII.addTwoNumbers(ListNode.fromList(l1), ListNode.fromList(l2))
        ListNode.toList(result) == expected

        where:
        l1                             | l2        | expected
        [7, 2, 4, 3]                   | [5, 6, 4] | [7, 8, 0, 7]
        [2, 4, 3]                      | [5, 6, 4] | [8, 0, 7]
        [0]                            | [0]       | [0]
        [3, 9, 9, 9, 9, 9, 9, 9, 9, 9] | [7]       | [4, 0, 0, 0, 0, 0, 0, 0, 0, 6]
    }
}
