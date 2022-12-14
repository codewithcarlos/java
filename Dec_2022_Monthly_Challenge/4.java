// https://leetcode.com/problems/minimum-average-difference/

class Solution {
  public int minimumAverageDifference(int[] nums) {
    int n = nums.length;
    int result = -1;
    int min = Integer.MAX_VALUE;
    long currSum = 0;

    long total = 0;
    for (int num : nums) {
      total += num;
    }

    for (int i = 0; i < nums.length; i++) {
      currSum += nums[i];
      long leftPart = currSum / (i + 1);
      long diff = total - currSum;
      long rightPart = n - i - 1 == 0 ? 0 : diff / (n - i - 1);
      int avgDiff = (int) Math.abs(leftPart - rightPart);
      if (avgDiff < min) {
        min = avgDiff;
        result = i;
      }
    }
    return result;
  }
}
