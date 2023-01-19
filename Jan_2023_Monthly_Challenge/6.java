// https://leetcode.com/problems/maximum-ice-cream-bars/description/

import java.util.*;

class Solution {
  public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int bars = 0;
    for (int cost : costs) {
      if (cost > coins)
        break;
      coins -= cost;
      bars++;
    }
    return bars;
  }
}