package arrays;

public class MaximumWealth_1672 {
    static class Solution {
        public int maximumWealth(int[][] accounts) {
            int m = accounts.length;
            int max = 0;
            for (int i = 0; i < m; i++) {
                int sum = 0;
                int n = accounts[i].length;
                for (int j = 0; j < n; j++) {
                    sum += accounts[i][j];
                }
                if (sum > max) {
                    max = sum;
                }
            }
            return max;
        }
    }
}
