package trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_0144 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

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
        List<Integer> result = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return result;
            }
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return result;
        }
    }
}
