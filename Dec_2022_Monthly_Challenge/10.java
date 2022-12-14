// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

class Solution {
  long result = 0;
  long sum = 0;

  public int maxProduct(TreeNode root) {
    double mod = Math.pow(10, 9) + 7;
    getSum(root);
    dfs(root);
    return (int) (result % mod);
  }

  public long dfs(TreeNode node) {
    if (node == null)
      return 0;
    long left = dfs(node.left);
    long right = dfs(node.right);
    long currSum = node.val + left + right;
    long newMaxProduct = currSum * (sum - currSum);
    if (newMaxProduct > result)
      result = newMaxProduct;
    return currSum;
  }

  public void getSum(TreeNode node) {
    if (node == null)
      return;
    sum += node.val;
    getSum(node.left);
    getSum(node.right);
  }
}
