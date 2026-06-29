package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum_0001_HashMap {
    // 两遍哈希
    static class Solution {
        int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int remaining = target - nums[i];
                if (map.containsKey(remaining)) {
                    int index = map.get(remaining);
                    if (index == i) {
                        continue;
                    }
                    return new int[] { i, index };
                }
            }
            return new int[] {};
        }
    }

    // 一遍哈希
    static class Solution_2 {
        int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int remaining = target - nums[i];
                if (map.containsKey(remaining)) {
                    return new int[] { i, map.get(remaining) };
                }
                // 如果哈希表里没有匹配的数字
                // 就把当前数字放入哈希表
                // 供后面的数字匹配
                map.put(nums[i], i);
            }
            return new int[] {};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(result));

        Solution_2 solution_2 = new Solution_2();
        int[] result_2 = solution_2.twoSum(new int[] { 2, 7, 11, 15 }, 9);
        System.out.println(Arrays.toString(result_2));
    }
}