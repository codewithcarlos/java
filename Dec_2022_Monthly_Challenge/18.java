// https://leetcode.com/problems/daily-temperatures/description/

import java.util.*;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    stack.add(0);
    for (int i = 1; i < n; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        int curr = stack.pop();
        result[curr] = i - curr;
      }
      stack.add(i);
    }
    return result;
  }
}