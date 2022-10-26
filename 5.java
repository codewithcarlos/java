import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-palindrome/description/

class BinarySearch {
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

class TwoPointer {
  public int[] sortedSquares(int[] nums) {
    int[] result = new int[nums.length];
    int l = 0;
    int r = nums.length - 1;
    int i = r;
    while (l <= r) {
      if (Math.abs(nums[l]) > Math.abs(nums[r])) {
        result[i] = nums[l] * nums[l];
        l++;
      } else {
        result[i] = nums[r] * nums[r];
        r--;
      }
      i--;
    }
    return result;
  }
}