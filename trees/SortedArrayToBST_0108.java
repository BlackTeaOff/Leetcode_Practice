package trees;

public class SortedArrayToBST_0108 {
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

    public static class MySolution {
        TreeNode recursion(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            // 避免溢出, 计算中点用 left + (right - left) / 2
            // 1/2 left + 1/2 right
            int pos = (left + right) / 2;
            TreeNode middle = new TreeNode(nums[pos]);
            middle.left = recursion(nums, left, pos - 1);
            middle.right = recursion(nums, pos + 1, right);
            return middle;
        }

        public TreeNode sortedArrayToBST(int[] nums) {
            return recursion(nums, 0, nums.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        MySolution mySolution = new MySolution();
        mySolution.sortedArrayToBST(nums);
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;

            TreeNode root = new TreeNode(nums[mid]);

            root.left = helper(nums, left, mid - 1);

            root.right = helper(nums, mid + 1, right);

            return root;
        }
    }
}