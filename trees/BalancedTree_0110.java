package trees;

public class BalancedTree_0110 {
    // 1. 标准的二叉树节点定义，方便你本地编译
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
        int recursion(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftHeight = recursion(node.left);
            // jian'zhijianzhi
            int rightHeight = recursion(node.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1000;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            return recursion(root) >= 0;
        }
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            // 如果高度返回的不是 -1，说明整棵树是平衡的
            return getHeight(root) != -1;
        }

        // 辅助方法：计算节点高度。如果子树不平衡，直接返回 -1（哨兵值）
        private int getHeight(TreeNode node) {
            if (node == null) {
                return 0; // 空节点高度为 0
            }

            // 计算左子树高度
            int leftHeight = getHeight(node.left);
            if (leftHeight == -1) {
                return -1; // 左子树已经不平衡了，直接往上传递 -1
            }

            // 计算右子树高度
            int rightHeight = getHeight(node.right);
            if (rightHeight == -1) {
                return -1; // 右子树已经不平衡了，直接往上传递 -1
            }

            // 如果左右子树高度差大于 1，说明当前节点不平衡，返回 -1
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            // 否则，返回当前节点的真实高度
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}