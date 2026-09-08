package math;

import java.math.BigInteger;

public class SqrtX_0069 {
    static class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = x >= 4 ? (x / 2) : x;
            int result = 0;
            BigInteger xB = BigInteger.valueOf(x);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                BigInteger bigInteger = BigInteger.valueOf(mid);
                BigInteger temp = bigInteger.multiply(bigInteger);
                if (temp.equals(xB)) {
                    return mid;
                }
                if (temp.compareTo(xB) == -1) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }

        public int mySqrt2(int x) {
            int left = 0;
            int right = x >= 4 ? (x / 2) : x;
            int result = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long temp = (long)mid * mid;
                if (temp == x) {
                    return mid;
                }
                if (temp < x) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.mySqrt2(2147395599));
        }
    }
}
