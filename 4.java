import java.util.*;

// https://leetcode.com/problems/continuous-subarray-sum/
class Solution {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int remainder = sum % k;
      if (!map.containsKey(remainder)) {
        map.put(remainder, i);
      } else if (i - map.get(remainder) > 1) {
        return true;
      }
    }
    return false;
  }
}