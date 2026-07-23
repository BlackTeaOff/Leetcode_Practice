package trees;

public class MaxDepth_0104 {
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

    public static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            // Java 直接用Math.max也行
            // return Math.max(left, right) + 1;
            // 或者直接
            // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            return (left >= right) ? left + 1 : right + 1;
        }
    }
}
