// https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/

// To convert number to a string can use String.valueOf() or Integer.toString()

class Solution {
  public int divisorSubstrings(int num, int k) {
    int result = 0;
    String str = Integer.toString(num);
    for (int i = 0; i <= str.length() - k; i++) {
      var n = Integer.parseInt(str.substring(i, i + k));
      if (n != 0 && num % n == 0)
        result++;
    }
    return result;
  }
}