package Jan_2023_Monthly_Challenge;

// https://leetcode.com/problems/word-pattern/

import java.util.*;

class Solution {
  public boolean wordPattern(String pattern, String s) {
    String[] sArr = s.split(" ");
    Map<Character, String> map = new HashMap<>();
    int i = 0;
    char[] p = pattern.toCharArray();
    if (pattern.length() != sArr.length)
      return false;
    Set<String> set = new HashSet<>();

    for (char c : p) {
      if (map.containsKey(c)) {
        if (!map.get(c).equals(sArr[i++]))
          return false;
      } else {
        if (set.contains(sArr[i]))
          return false;
        map.put(c, sArr[i]);
        set.add(sArr[i]);
        i++;
      }
    }

    return true;
  }
}