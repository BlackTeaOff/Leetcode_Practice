package trees;
public class MinDepth_0111 {
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
        int recursion(TreeNode node, int depth) {
            if (node == null) {
                return Integer.MAX_VALUE;
            }
            depth += 1;
            if (node.left == null && node.right == null) {
                return depth;
            }

            int minLeft = recursion(node.left, depth);
            int minRight = recursion(node.right, depth);

            return minLeft < minRight ? minLeft : minRight;
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return recursion(root, 0);
        }
    }
}
