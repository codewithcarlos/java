// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.*;

class Solution {
  public String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    List<Character> list = new ArrayList<>(map.keySet());
    Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

    StringBuilder sb = new StringBuilder();
    for (char letter : list) {
      for (int i = 0; i < map.get(letter); i++) {
        sb.append(letter);
      }
    }
    return sb.toString();
  }
}
