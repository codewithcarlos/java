package Jan_2023_Monthly_Challenge;

// https://leetcode.com/problems/detect-capital/

class Solution {
  public boolean detectCapitalUse(String word) {
    boolean isFirstCapital = false;
    int capitalizedCount = 0;
    int A = 'A';
    int Z = 'Z';
    if (word.charAt(0) >= A && word.charAt(0) <= Z) {
      isFirstCapital = true;
      capitalizedCount++;
    }
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) >= A && word.charAt(i) <= Z) {
        capitalizedCount++;
      }
    }
    return capitalizedCount == 0 ||
        capitalizedCount == word.length() ||
        isFirstCapital && capitalizedCount == 1;
  }
}