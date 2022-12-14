// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
package Dec_2022_Monthly_Challenge;

class Solution {
  int result = 0;

  public int maxAncestorDiff(TreeNode root) {
    dfs(root, root.val, root.val);
    return result;
  }

  public void dfs(TreeNode node, long min, long max) {
    if (node == null)
      return;
    if (node.val < min)
      min = node.val;
    if (node.val > max)
      max = node.val;
    int diff = (int) Math.max(Math.abs(max - node.val), Math.abs(min - node.val));
    if (diff > result)
      result = diff;
    dfs(node.left, min, max);
    dfs(node.right, min, max);
  }
}
