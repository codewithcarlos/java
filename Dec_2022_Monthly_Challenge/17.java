
// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
import java.util.*;

class Solution {
  public int evalRPN(String[] tokens) {
    Set<String> set = new HashSet<>();
    set.add("+");
    set.add("-");
    set.add("*");
    set.add("/");
    Stack<Integer> stack = new Stack<>();
    for (String t : tokens) {
      if (set.contains(t)) {
        int el2 = stack.pop();
        int el1 = stack.pop();
        if (t.equals("+")) {
          stack.push(el1 + el2);
        } else if (t.equals("-")) {
          stack.push(el1 - el2);
        } else if (t.equals("*")) {
          stack.push(el1 * el2);
        } else {
          stack.push(el1 / el2);
        }
      } else {
        stack.push(Integer.parseInt(t));
      }
    }
    return stack.pop();
  }
}