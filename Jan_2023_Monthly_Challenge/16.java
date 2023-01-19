// https://leetcode.com/problems/insert-interval/description/

import java.util.*;;

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>();

    for (int[] interval : intervals) {
      if (newInterval[1] < interval[0]) {
        list.add(newInterval);
        newInterval = interval;
      } else if (newInterval[0] > interval[1]) {
        list.add(interval);
      } else {
        newInterval[0] = Math.min(newInterval[0], interval[0]);
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      }
    }

    list.add(newInterval);
    return list.toArray(new int[list.size()][]);
  }
}