// https://leetcode.com/problems/find-if-path-exists-in-graph/

import java.util.*;

class Solution {
  Map<Integer, Set<Integer>> map;
  Set<Integer> set;

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    map = new HashMap<>();
    set = new HashSet<>();
    for (int[] edge : edges) {
      if (!map.containsKey(edge[0]))
        map.put(edge[0], new HashSet<>());
      map.get(edge[0]).add(edge[1]);
      if (!map.containsKey(edge[1]))
        map.put(edge[1], new HashSet<>());
      map.get(edge[1]).add(edge[0]);
    }
    return pathExists(source, destination);
  }

  public boolean pathExists(int source, int destination) {
    if (set.contains(source))
      return false;
    Set<Integer> neighbors = map.getOrDefault(source, new HashSet<>());
    if (neighbors.contains(destination) || source == destination)
      return true;
    set.add(source);
    for (int neighbor : neighbors) {
      if (pathExists(neighbor, destination))
        return true;
    }
    return false;
  }
}