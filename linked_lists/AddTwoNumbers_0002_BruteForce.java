package linked_lists;

import java.math.BigInteger;

public class AddTwoNumbers_0002_BruteForce{
    // 静态类, 不依赖对象存在, AddTwoNumbers相当于它的命名空间
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            StringBuilder num1 = new StringBuilder();
            StringBuilder num2 = new StringBuilder();

            while (l1 != null) {
                num1.append(l1.val); 
                l1 = l1.next;
            }
            // System.out.println(num1);

            while (l2 != null) {
                num2.append(l2.val);
                l2 = l2.next; 
            }
            // System.out.println(num2);

            BigInteger b1 = new BigInteger(num1.reverse().toString());
            BigInteger b2 = new BigInteger(num2.reverse().toString());

            // System.out.println(b1);
            // System.out.println(b2);

            BigInteger sum = b1.add(b2);
            // System.out.println(sum);

            String sumString = String.valueOf(sum);
            // System.out.println(sumString);
            // long sum = num1 + num2;

            // String sumString = String.valueOf(sum);
            ListNode result = new ListNode(Character.getNumericValue(sumString.charAt(sumString.length() - 1)));
            ListNode temp = result;
            for (int i = sumString.length() - 2; i >= 0; i--) {
                while (temp.next != null) {
                    temp = temp.next;
                }
                // System.out.println(sumString.charAt(i));
                temp.next = new ListNode(Character.getNumericValue(sumString.charAt(i)));
            }
            return result;
            // return new ListNode(0);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        ListNode l3 = new ListNode(1);
        ListNode temp = l3;
        for (int i = 0; i < 9; i++) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(9);
        }

        ListNode l4 = new ListNode(9);

        // temp = l3;
        // while (temp != null) {
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        ListNode result2 = solution.addTwoNumbers(l4, l3);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }
}
