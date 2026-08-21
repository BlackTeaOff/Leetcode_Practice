package trees;

public class LowestCommonAncestor_0236 {
    // 标准的二叉树节点定义
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

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 基础防守：如果当前节点为空，或者当前节点就是 p 或 q，直接返回当前节点
            if (root == null || root == p || root == q) {
                return root;
            }

            // 递归在左子树中寻找 p 或 q
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 递归在右子树中寻找 p 或 q
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // 核心判定：如果左子树和右子树都找到了非空节点，说明当前节点就是分叉点，即最近公共祖先
            if (left != null && right != null) {
                return root;
            }

            // 如果只有一侧找到了，说明公共祖先在找到的那一侧，将其往上传递
            return left != null ? left : right;
        }
    }
}