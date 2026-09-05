package trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar_0872 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        void recursion(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            recursion(root.left, list);
            recursion(root.right, list);
        }

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            recursion(root1, list1);
            recursion(root2, list2);
            return list1.equals(list2);
        }
    }
}
