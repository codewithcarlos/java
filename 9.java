// https://leetcode.com/problems/merge-in-between-linked-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode A = list1;
    ListNode B = list1;
    b = b - a;
    while (a > 1) {
      A = A.next;
      a--;
    }
    B = A.next;
    while (b >= 0) {
      B = B.next;
      b--;
    }
    A.next = list2;
    ListNode curr = list2;
    while (curr != null && curr.next != null) {
      curr = curr.next;
    }
    curr.next = B;
    return list1;
  }
}