package trees;

public class DiameterOfBinaryTree_0543 {
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
        int diameter = 0;

        int recursion(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftDepth = recursion(node.left);
            int rightDepth = recursion(node.right);
            diameter = Math.max(diameter, leftDepth + rightDepth);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }

        public int diameterOfBinaryTree(TreeNode root) {
            recursion(root);
            return diameter;
        }
    }

    static class Solution {
        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return maxDiameter;
        }

        private int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftDepth = depth(node.left);
            int rightDepth = depth(node.right);

            maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}