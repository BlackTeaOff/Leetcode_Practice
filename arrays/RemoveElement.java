package arrays;

public class RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int left = 0;
            int right = nums.length - 1;
            int same = 0;

            while (left < right) {
                while (right >= 0 && nums[right] == val) {
                    right = right - 1;
                    same += 1;
                }

                if (nums[left] == val && left < right) {
                    int temp = nums[right];
                    nums[right] = val;
                    nums[left] = temp;
                    right -= 1;
                    same += 1;
                }

                left += 1;
            }
            if (nums.length != 0 && left == right && nums[left] == val) {
                same += 1;
            }
            return nums.length - same;
        }

        public int removeElement2(int[] nums, int val) {
            int slow = 0;
            
            for (int fast = 0; fast < nums.length; fast++) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                } 
            } 
            return slow;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = new int[] { 2, 4, 4, 4, 0 };
        System.out.println(solution.removeElement(test, 4));
        for (int i : test) {
            System.out.println(i);
        }
    }
}