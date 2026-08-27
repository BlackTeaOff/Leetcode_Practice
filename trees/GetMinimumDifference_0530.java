package trees;

public class GetMinimumDifference_0530 {
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

    static class MySolution {
        TreeNode lastTree = null;
        int min = Integer.MAX_VALUE;

        public void recursion(TreeNode root) {
            if (root == null) {
                return;
            }
            recursion(root.left);
            if (lastTree != null) {
                min = min < root.val - lastTree.val ? min : root.val - lastTree.val;
            }
            lastTree = root;
            recursion(root.right);
        }

        public int getMinimumDifference(TreeNode root) {
            recursion(root);
            return min;
        }
    }

    static class Solution {
        private int minDiff = Integer.MAX_VALUE;
        private TreeNode prev = null;

        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return minDiff;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }

            inorder(root.left);

            if (prev != null) {
                minDiff = Math.min(minDiff, root.val - prev.val);
            }
            prev = root;

            inorder(root.right);
        }
    }
}