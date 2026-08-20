package trees;

public class CountNodes_0222 {
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // int leftHeight = -1;
            // int rightHeight = -1;
            int leftHeight = 0;
            int rightHeight = 0;
            TreeNode temp = root;
            // 计算这个节点一直向左/右高度
            // 如果相等代表是满二叉树, 直接用公式, 并且就不用顺着这个节点往下找了(剪枝)
            // 不相等就不是满二叉树, 用 1 + countNode(node.left) + countNode(node.right)
            while (temp != null) {
                temp = temp.left;
                leftHeight++;
            }
            temp = root;
            while (temp != null) {
                temp = temp.right;
                rightHeight++;
            }
            if (leftHeight == rightHeight) {
                return (int) Math.pow(2, rightHeight) - 1;
                // return (int)Math.pow(2, rightHeight + 1) - 1;
            } else {
                return 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
    }

    // static class MySolution {
    //     int maxDepth = 0;
    //     boolean finished = false;
    //     int recursion(TreeNode node, int sum, int depth) {
    //         if (node == null) {
    //             return sum;
    //         }
    //         maxDepth = Math.max(maxDepth, depth);
    //         if (!finished) {
    //             sum = recursion(node.left, sum, depth + 1);
    //         }
    //         if (depth == maxDepth - 1) {
    //             if (node.left != null && node.right != null) {
    //                 sum += 2;
    //                 return sum;
    //             } else if (node.left == null || node.right == null) {
    //                 sum += 1;
    //                 finished = true;
    //                 return sum;
    //             } else { // left == right == null
    //                 finished = true;
    //                 return sum;
    //             }
    //         }
    //         if (!finished) {
    //             sum = recursion(node.right, sum, depth + 1);
    //         }
    //         return sum;
    //     }

    //     public int countNodes(TreeNode root) {
    //         return recursion(root, 0, 0) + ((int) Math.pow(2, maxDepth - 1) - 1);
    //     }
    // }















    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}