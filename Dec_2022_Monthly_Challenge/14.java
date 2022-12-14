// https://leetcode.com/problems/house-robber/

class Solution {
  public int rob(int[] nums) {
    int n = nums.length;
    int prev = nums[n - 1];
    int beforePrev = 0;
    for (int i = n - 2; i >= 0; i--) {
      int curr = Math.max(nums[i] + beforePrev, prev);
      beforePrev = prev;
      prev = curr;
    }
    return prev;
  }
}
