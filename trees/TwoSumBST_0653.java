package trees;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST_0653 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class MySolution {
        Set<Integer> hashSet = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            if (hashSet.contains(root.val)) {
                return true;
            }
            hashSet.add(k - root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
    
    static class Solution {
        private Set<Integer> set = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }

            if (set.contains(k - root.val)) {
                return true;
            }
            
            set.add(root.val);
            
            return findTarget(root.left, k) || findTarget(root.right, k);
        }
    }
}