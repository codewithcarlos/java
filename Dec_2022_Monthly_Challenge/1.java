// https://leetcode.com/problems/determine-if-string-halves-are-alike/

import java.util.*;

class Solution {
  public boolean halvesAreAlike(String s) {
    int count = 0;
    Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    int mid = s.length() / 2;
    for (int i = 0; i < mid; i++) {
      if (set.contains(s.charAt(i)))
        count++;
    }
    for (int i = mid; i < s.length(); i++) {
      if (set.contains(s.charAt(i)))
        count--;
    }
    return count == 0;
  }
}