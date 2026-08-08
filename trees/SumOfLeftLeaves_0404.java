package trees;

public class SumOfLeftLeaves_0404 {
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

    class mySolution {
        int recursion(TreeNode node, boolean isLeftNode) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                if (isLeftNode) {
                    return node.val;
                } else {
                    return 0;
                }
            }
            // 不是叶子节点就遍历左右
            return recursion(node.left, true) + recursion(node.right, false);
        }

        public int sumOfLeftLeaves(TreeNode root) {
            return recursion(root, false);
        }
    }

    static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int sum = 0;

            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }

            return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}