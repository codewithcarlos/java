// https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
  public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[] dp = new int[n + 1];

    for (int r = 0; r < n; r++) {
      int[] curr = new int[n + 1];
      for (int c = 0; c < n; c++) {
        if (c == 0) {
          curr[c] = Math.min(dp[c], dp[c + 1]) + matrix[r][c];
        } else if (c == n - 1) {
          curr[c] = Math.min(dp[c], dp[c - 1]) + matrix[r][c];
        } else {
          curr[c] = Math.min(Math.min(dp[c], dp[c - 1]), dp[c + 1]) + matrix[r][c];
        }
      }
      dp = curr;
    }
    int result = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      if (dp[i] < result)
        result = dp[i];
    }
    return result;
  }
}
