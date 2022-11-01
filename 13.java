
// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// Top-down approach
import java.util.*;

class Solution {
  Map<Integer, Integer> memo = new HashMap<>();

  public int minCostClimbingStairs(int[] cost) {
    return dfs(cost.length, cost);
  }

  public int dfs(int i, int[] cost) {
    if (i <= 1)
      return 0;
    if (memo.containsKey(i))
      return memo.get(i);

    int prev = cost[i - 1] + dfs(i - 1, cost);
    int beforePrev = cost[i - 2] + dfs(i - 2, cost);
    memo.put(i, Math.min(prev, beforePrev));
    return memo.get(i);
  }
}