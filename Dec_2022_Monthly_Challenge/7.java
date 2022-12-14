// https://leetcode.com/problems/range-sum-of-bst/
package Dec_2022_Monthly_Challenge;

class Solution {
  int sum;

  public int rangeSumBST(TreeNode root, int low, int high) {
    sum = 0;
    dfs(root, low, high);
    return sum;
  }

  public void dfs(TreeNode node, int low, int high) {
    if (node == null)
      return;
    if (node.val >= low && node.val <= high) {
      sum += node.val;
    }
    if (node.val > low) {
      dfs(node.left, low, high);
    }
    if (node.val < high) {
      dfs(node.right, low, high);
    }
  }
}
