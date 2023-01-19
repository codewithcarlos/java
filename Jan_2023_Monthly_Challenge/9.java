
// https://leetcode.com/problems/binary-tree-preorder-traversal/description/
import java.util.*;;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  List<Integer> result;

  public List<Integer> preorderTraversal(TreeNode root) {
    result = new ArrayList<>();
    dfs(root);
    if (root == null)
      return result;
    return result;
  }

  public void dfs(TreeNode node) {
    if (node == null)
      return;
    result.add(node.val);
    dfs(node.left);
    dfs(node.right);
  }
}