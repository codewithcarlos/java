
// https://leetcode.com/problems/all-paths-from-source-to-target/description/
import java.util.*;

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(0, path, graph);
    return result;
  }

  public void dfs(int start, List<Integer> path, int[][] graph) {
    int[] neighbors = graph[start];
    if (start == graph.length - 1) {
      result.add(new ArrayList<>(path));
      return;
    }
    for (int neighbor : neighbors) {
      path.add(neighbor);
      dfs(neighbor, path, graph);
      path.remove(path.size() - 1);
    }
  }
}