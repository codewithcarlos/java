package Jan_2023_Monthly_Challenge;

// https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

import java.util.*;;

class Solution {
  public int minimumRounds(int[] tasks) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int task : tasks) {
      if (!map.containsKey(task))
        map.put(task, 0);
      map.put(task, map.get(task) + 1);
    }
    int rounds = 0;
    for (int value : map.values()) {
      if (value == 1)
        return -1;
      if (value % 3 == 0) {
        rounds += value / 3;
      } else {
        rounds += value / 3 + 1;
      }
    }
    return rounds;
  }
}