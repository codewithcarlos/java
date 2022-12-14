// https://leetcode.com/problems/climbing-stairs/
package Dec_2022_Monthly_Challenge;

class Solution {
  public int climbStairs(int n) {
    int prev = 1;
    int curr = 1;
    for (int i = 2; i <= n; i++) {
      int tmp = curr;
      curr = curr + prev;
      prev = tmp;
    }
    return curr;
  }
}
