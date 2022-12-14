// https://leetcode.com/problems/middle-of-the-linked-list/
package Dec_2022_Monthly_Challenge;

class Solution {
  public ListNode middleNode(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
