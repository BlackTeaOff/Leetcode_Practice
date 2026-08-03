package trees;

public class SymmetricTree_0101 {
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
        boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            if (!isMirror(left.left, right.right)) {
                return false;
            }
            if (!isMirror(left.right, right.left)) {
                return false;
            }
            return true;
        }

        public boolean isSymmetric(TreeNode root) {
            return isMirror(root.left, root.right);
        }
    }
}
