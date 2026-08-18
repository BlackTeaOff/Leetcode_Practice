package trees;

public class MergeTrees_0617 {
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            // 前两个 if 可以删掉, 因为下面两个 if 已经涵盖了所有情况
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 != null && root2 != null) {
                root1.val += root2.val;
            } else if (root1 == null) {
                return root2;
            } else if (root2 == null) {
                return root1;
            }
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }

            TreeNode merged = new TreeNode(root1.val + root2.val);

            merged.left = mergeTrees(root1.left, root2.left);
            merged.right = mergeTrees(root1.right, root2.right);

            return merged;
        }
    }
}