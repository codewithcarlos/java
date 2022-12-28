
// https://leetcode.com/problems/group-anagrams/description/
import java.util.*;

class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] alpha = new char[26];
      for (char c : str.toCharArray()) {
        alpha[c - 'a']++;
      }
      String key = String.valueOf(alpha);
      if (!map.containsKey(key))
        map.put(key, new ArrayList<>());
      map.get(key).add(str);
    }

    return new ArrayList(map.values());
  }
}