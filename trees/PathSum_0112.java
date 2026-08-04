package trees;

public class PathSum_0112 {
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
        boolean recursion(TreeNode node, int sum, int targetSum) {
            if (node == null) {
                return false;
            }
            sum += node.val;
            if (node.left == null && node.right == null) {
                if (sum == targetSum) {
                    return true;
                }
                return false;
            }
            return recursion(node.left, sum, targetSum) || recursion(node.right, sum, targetSum);
        }

        public boolean hasPathSum(TreeNode root, int targetSum) {
            return recursion(root, 0, targetSum);
        }
        
        // 做减法
        public boolean hasPathSum2(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            targetSum -= root.val;
            if (root.left == null && root.right == null) {
                if (targetSum == 0) {
                    return true;
                }
                return false;
            }
    
            return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
        }
    }
}
