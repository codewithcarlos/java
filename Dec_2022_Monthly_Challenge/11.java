// https://leetcode.com/problems/binary-tree-maximum-path-sum/
package Dec_2022_Monthly_Challenge;

class Solution {
  int sum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return sum;
  }

  public int dfs(TreeNode node) {
    if (node == null)
      return 0;
    int left = Math.max(0, dfs(node.left));
    int right = Math.max(0, dfs(node.right));
    int newSum = node.val + left + right;
    if (newSum > sum)
      sum = newSum;
    return node.val + Math.max(left, right);
  }
}
