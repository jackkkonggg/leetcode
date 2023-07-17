package org.jackkkonggg.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jack Ong
 * @date: 2023/07/17 09:38
 */
public class ListNode {
  public int val;
  public ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static List<Integer> toList(ListNode head) {
    List<Integer> arrayList = new ArrayList<>();
    while (head != null) {
      arrayList.add(head.val);
      head = head.next;
    }
    return arrayList;
  }

  public static ListNode fromList(List<Integer> list) {
    ListNode head = new ListNode(list.get(0));
    ListNode curr = head;
    for (int i = 1; i < list.size(); ++i) {
      curr.next = new ListNode(list.get(i));
      curr = curr.next;
    }

    return head;
  }
}
