package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_0257 {
    static class TreeNode {
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
        List<String> result = new ArrayList<>();

        void recursion(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return;
            }
            StringBuilder tSb;
            if (sb != null) {
                tSb = new StringBuilder(sb.toString());
            } else {
                tSb = new StringBuilder();
            }
            tSb.append(node.val);
            if (node.left == null && node.right == null) {
                result.add(tSb.toString());
                return;
            }
            tSb.append("->");
            recursion(node.left, tSb);
            recursion(node.right, tSb);
        }

        public List<String> binaryTreePaths(TreeNode root) {
            recursion(root, null);
            return result;
        }

        // void recursion(TreeNode node, StringBuilder sb) {
        //     if (node == null) {
        //         return;
        //     }
        //     sb.append(node.val);
        //     if (node.left == null && node.right == null) {
        //         result.add(sb.toString());
        //         return;
        //     }
        //     recursion(node.left, sb);
        //     recursion(node.right, sb);
        // }

        // StringBuilder sb = new StringBuilder();
        
        // public List<String> binaryTreePaths(TreeNode root) {
        //     if (root == null) {
        //         return result;
        //     }
        //     sb.append("->");
        //     sb.append(root.val);
        //     if (root.left == null && root.right == null) {
        //         result.add(sb.toString());
        //         sb.deleteCharAt(sb.length() - 1);
        //         return result;
        //     }
        //     binaryTreePaths(root.left);
        //     binaryTreePaths(root.right);
        //     sb.deleteCharAt(sb.length() - 1);
        //     return result;
        // }
    }
}
