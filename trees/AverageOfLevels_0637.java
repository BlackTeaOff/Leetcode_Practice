package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels_0637 {
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
    
    class MySolution {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            List<Double> result = new ArrayList<>();
            if (root == null) {
                return null;
            }
            queue.add(root);
            long sum = 0;
            int num;
            while (!queue.isEmpty()) {
                num = queue.size();
                for (int i = 0; i < num; i++) {
                    TreeNode temp = queue.poll();
                    sum += temp.val;
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
                result.add((double)sum / num);
                sum = 0;
            }
            return result;
        }
    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                double sum = 0;

                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    sum += curr.val;

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
                result.add(sum / size);
            }

            return result;
        }
    }
}