package trees;

public class Subtree_0572 {
    public static class TreeNode {
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

    class Solution {
        boolean isSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }

            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // root 为空就不可能是子树, 直接返回 false
            if (root == null) {
                return false;
            }
            if (isSameTree(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }
}
