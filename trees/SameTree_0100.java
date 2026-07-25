package trees;

public class SameTree_0100 {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p == null && q != null) || (p != null && q == null)) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            if (!isSameTree(p.left, q.left)) {
                return false;
            }
            if (!isSameTree(p.right, q.right)) {
                return false;
            }
            return true;
        }

        public boolean isSameTree2(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            // 上面已经处理了二者都为空的情况
            // 这里只能是其中一个为空
            if (p == null || q == null) {
                return false;
            }

            // 必须同时为真才返回真, 否则为假
            return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        }
    }
}
