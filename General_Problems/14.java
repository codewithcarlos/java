
// https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
import java.util.*;

class Solution {
  public List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> lost = new HashMap<>();
    for (int i = 0; i < matches.length; i++) {
      int[] match = matches[i];
      lost.put(match[0], lost.getOrDefault(match[0], 0) + 0);
      lost.put(match[1], lost.getOrDefault(match[1], 0) + 1);
    }

    List<Integer> noLoss = new ArrayList<>();
    List<Integer> oneLoss = new ArrayList<>();
    for (Map.Entry<Integer, Integer> el : lost.entrySet()) {
      if (el.getValue() == 0) {
        noLoss.add(el.getKey());
      } else if (el.getValue() == 1) {
        oneLoss.add(el.getKey());
      }
    }
    noLoss.sort((a, b) -> a - b);
    oneLoss.sort((a, b) -> a - b);
    List<List<Integer>> result = new ArrayList<>();
    result.add(noLoss);
    result.add(oneLoss);
    return result;
  }
}