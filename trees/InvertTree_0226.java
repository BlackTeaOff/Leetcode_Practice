package trees;

public class InvertTree_0226 {
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
        public void recursion(TreeNode root) {
            if (root == null) {
                return;
            }
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        public TreeNode invertTree(TreeNode root) {
            recursion(root);
            return root;
        }

        // 无需再写一个recursion的方法
        public TreeNode invertTree2(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree2(root.left);
            TreeNode right = invertTree2(root.right);

            root.left = right;
            root.right = left;

            return root;
        }

        public void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        Solution solution = new Solution();
        solution.preOrder(root);
        System.out.println();
        solution.invertTree(root);
        solution.preOrder(root);
    }
}
