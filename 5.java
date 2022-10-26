import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome/description/

class Solution {
  public int longestPalindrome(String s) {
    int leftover = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int result = 0;
    for (int value : map.values()) {
      while (value > 1) {
        result += 2;
        value -= 2;
      }
      if (leftover == 0 && value == 1) {
        leftover = 1;
      }
    }
    return result + leftover;
  }
}