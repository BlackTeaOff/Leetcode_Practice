package arrays;

public class SingalNumber_136 {
    static class Solution {
        public int singalNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                // 0和任何数异或都为它本身
                // 两个相同的数异或为0, 会抵消
                // 其他数字只出现两边
                // 所以都会抵消, 最后剩下的就是只出现一次的数
                ans ^= num;
            }
            return ans;
        }
    }
}