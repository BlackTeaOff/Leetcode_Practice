package trees;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrder_0102 {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int num = 1;
            // 用队列 size 可直接判断该层节点个数
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int node_num = 0;
                for (int i = 0; i < num; i++) {
                    TreeNode temp = queue.poll();
                    level.add(temp.val);
                    if (temp.left != null) {
                        // 用 offer 队列满时不会抛出异常
                        queue.add(temp.left);
                        node_num += 1;
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                        node_num += 1;
                    }
                }
                num = node_num;
                result.add(level);
            }
            return result;
        }
    }
}
