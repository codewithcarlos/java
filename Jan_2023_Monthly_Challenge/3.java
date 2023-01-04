package Jan_2023_Monthly_Challenge;

// https://leetcode.com/problems/delete-columns-to-make-sorted/

class Solution {
  public int minDeletionSize(String[] strs) {
    int R = strs.length;
    int C = strs[0].length();
    int deleteCount = 0;

    for (int c = 0; c < C; c++) {
      for (int r = 0; r < R - 1; r++) {
        if (strs[r + 1].charAt(c) < strs[r].charAt(c)) {
          deleteCount++;
          break;
        }
      }
    }

    return deleteCount;
  }
}