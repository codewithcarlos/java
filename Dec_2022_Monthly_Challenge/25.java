// https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/

import java.util.*;

class Solution {
  public int[] answerQueries(int[] nums, int[] queries) {
    int[] result = new int[queries.length];
    Arrays.sort(nums);

    int currSum = 0;
    for (int j = 0; j < nums.length; j++) {
      currSum += nums[j];
      nums[j] = currSum;
    }

    for (int i = 0; i < queries.length; i++) {
      result[i] = binarySearch(nums, queries[i]);
    }

    return result;
  }

  public int binarySearch(int[] nums, int target) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[mid] == target)
        return mid + 1;
      if (nums[mid] > target) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return nums[l] > target ? l : l + 1;
  }
}
