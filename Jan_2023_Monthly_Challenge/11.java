// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

import java.util.*;;

class Solution {
  List<Boolean> hasApple;
  Map<Integer, List<Integer>> map;

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    this.hasApple = hasApple;
    map = new HashMap<>();
    for (int[] edge : edges) {
      if (!map.containsKey(edge[0]))
        map.put(edge[0], new ArrayList<>());
      if (!map.containsKey(edge[1]))
        map.put(edge[1], new ArrayList<>());
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    return dfs(0, -1);
  }

  public int dfs(int node, int parent) {
    if (!map.containsKey(node))
      return 0;

    int totalTime = 0;
    int childTime = 0;
    for (int child : map.get(node)) {
      if (child == parent)
        continue;
      childTime = dfs(child, node);
      if (childTime > 0 || hasApple.get(child)) {
        totalTime += childTime + 2;
      }
    }

    return totalTime;
  }
}
