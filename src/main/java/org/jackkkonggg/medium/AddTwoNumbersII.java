package org.jackkkonggg.medium;

import org.jackkkonggg.structure.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jack Ong
 * @date: 2023/07/17 09:26
 */
public class AddTwoNumbersII {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger i1 = listToInteger(ListNode.toList(l1));
    BigInteger i2 = listToInteger(ListNode.toList(l2));
    BigInteger sum = i1.add(i2);

    return ListNode.fromList(bigIntToList(sum));
  }

  private BigInteger listToInteger(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (int digit : list) sb.append(digit);
    return new BigInteger(sb.toString());
  }

  private List<Integer> bigIntToList(BigInteger num) {
    List<Integer> list = new ArrayList<>();
    for (char c : num.toString().toCharArray()) {
      list.add(Character.getNumericValue(c));
    }

    return list;
  }
}
