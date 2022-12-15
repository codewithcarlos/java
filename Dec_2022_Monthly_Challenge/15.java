// https://leetcode.com/problems/longest-common-subsequence/description/

// Top down recursion
class Solution {
  int[][] memo;
  String t1;
  String t2;

  public int longestCommonSubsequence(String text1, String text2) {
    t1 = text1;
    t2 = text2;
    memo = new int[t1.length() + 1][t2.length() + 1];
    return this.recurse(0, 0);
  }

  public int recurse(int p1, int p2) {
    if (p1 == t1.length() || p2 == t2.length())
      return 0;
    if (memo[p1][p2] > 0)
      return memo[p1][p2];

    int result = 0;
    if (t1.charAt(p1) == t2.charAt(p2)) {
      result = 1 + recurse(p1 + 1, p2 + 1);
    } else {
      result = Math.max(recurse(p1 + 1, p2), recurse(p1, p2 + 1));
    }
    memo[p1][p2] = result;
    return memo[p1][p2];
  }
}