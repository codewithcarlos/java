// https://leetcode.com/problems/possible-bipartition/description/

import java.util.*;

class SolutionBFS {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] dislike : dislikes) {
      int a = dislike[0];
      int b = dislike[1];
      map.putIfAbsent(a, new ArrayList<>());
      map.putIfAbsent(b, new ArrayList<>());
      map.get(a).add(b);
      map.get(b).add(a);
    }

    int[] colors = new int[n + 1];
    Arrays.fill(colors, -1); // -1 means not visited

    for (int i = 1; i <= n; i++) {
      if (colors[i] == -1) {
        if (!bfs(i, colors, map))
          return false;
      }
    }
    return true;
  }

  public boolean bfs(int i, int[] colors, Map<Integer, List<Integer>> map) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(i);
    colors[i] = 0;
    while (!q.isEmpty()) {
      int n = q.size();
      for (int j = 0; j < n; j++) {
        int node = q.poll();
        if (!map.containsKey(node))
          continue;
        for (int neighbor : map.get(node)) {
          // if disliked neighbor in same group return false
          if (colors[neighbor] == colors[node])
            return false;
          // if not visited put neighbor in other group and add to queue
          if (colors[neighbor] == -1) {
            colors[neighbor] = 1 - colors[node];
            q.add(neighbor);
          }
        }
      }
    }
    return true;
  }
}

class SolutionDFS {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] dislike : dislikes) {
      int a = dislike[0];
      int b = dislike[1];
      map.putIfAbsent(a, new ArrayList<>());
      map.putIfAbsent(b, new ArrayList<>());
      map.get(a).add(b);
      map.get(b).add(a);
    }

    int[] colors = new int[n + 1];
    Arrays.fill(colors, -1); // -1 means not visited

    for (int i = 1; i <= n; i++) {
      if (colors[i] == -1) {
        if (!dfs(i, 0, colors, map))
          return false;
      }
    }
    return true;
  }

  public boolean dfs(int i, int color, int[] colors, Map<Integer, List<Integer>> map) {
    if (!map.containsKey(i))
      return true;
    colors[i] = color;
    for (int neighbor : map.get(i)) {
      if (colors[neighbor] == colors[i])
        return false;
      if (colors[neighbor] == -1) {
        if (!dfs(neighbor, 1 - colors[i], colors, map))
          return false;
      }
    }
    return true;
  }
}