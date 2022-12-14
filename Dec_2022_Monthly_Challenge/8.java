// https://leetcode.com/problems/leaf-similar-trees/

import java.util.*;

class Solution {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    leafValueSequence(root1, list1);
    leafValueSequence(root2, list2);
    return list1.equals(list2);
  }

  public void leafValueSequence(TreeNode node, List<Integer> list) {
    if (node.left == null & node.right == null) {
      list.add(node.val);
    }
    if (node.left != null)
      leafValueSequence(node.left, list);
    if (node.right != null)
      leafValueSequence(node.right, list);
  }
}
