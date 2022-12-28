
// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
import java.util.*;

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (q.size() > 0) {
      int n = q.size();
      List<Integer> current = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        TreeNode node = q.remove();
        current.add(node.val);
        if (node.left != null)
          q.add((node.left));
        if (node.right != null)
          q.add((node.right));
      }
      result.add(current);
    }
    return result;
  }
}