// https://leetcode.com/problems/word-ladder/description/

import java.util.*;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord))
      return 0;
    Map<String, HashSet<String>> nei = new HashMap<>();
    for (String word : wordList) {
      for (int j = 0; j < word.length(); j++) {
        String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
        if (!nei.containsKey(pattern)) {
          nei.put(pattern, new HashSet<String>());
        }
        var neighbor = nei.get(pattern);
        neighbor.add(word.toString());
      }
    }
    Set<String> visit = new HashSet<>();
    visit.add(beginWord);
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    int res = 1;
    while (q.size() > 0) {
      int n = q.size();
      for (int i = 0; i < n; i++) {
        var word = q.remove();
        if (word.equals(endWord))
          return res;
        for (int j = 0; j < word.length(); j++) {
          String pattern = word.substring(0, j) + '*' + word.substring(j + 1);
          var neighbors = nei.getOrDefault(pattern, new HashSet<String>());
          ArrayList<String> arr = new ArrayList<>(neighbors);
          for (String neiWord : arr) {
            if (!visit.contains(neiWord)) {
              visit.add(neiWord);
              q.add(neiWord);
            }
          }
        }
      }
      res++;
    }
    return 0;
  }
}