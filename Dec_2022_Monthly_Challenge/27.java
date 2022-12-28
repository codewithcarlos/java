// https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/

import java.util.*;

class Solution {
  public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
    for (int i = 0; i < rocks.length; i++) {
      capacity[i] -= rocks[i];
    }
    Arrays.sort(capacity);
    int fullBags = 0;
    for (int i = 0; i < rocks.length; i++) {
      if (additionalRocks >= capacity[i]) {
        additionalRocks -= capacity[i];
        fullBags++;
      } else {
        break;
      }
    }
    return fullBags;
  }
}