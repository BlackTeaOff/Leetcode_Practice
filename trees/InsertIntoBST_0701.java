package trees;

public class InsertIntoBST_0701 {
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
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    return root;
                }
                insertIntoBST(root.left, val);
            } else {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    return root;
                }
                insertIntoBST(root.right, val);
            }
            return root;
        }
    }

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            }

            else {
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }
}