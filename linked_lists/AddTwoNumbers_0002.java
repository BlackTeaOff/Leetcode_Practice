package linked_lists;

public class AddTwoNumbers_0002 {
    static class ListNode {
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
            int carry = 0;
            int sum = 0;
            int num = 0;
            ListNode result = new ListNode();
            ListNode tail = result;
            while (l1 != null || l2 != null) {
                if (l1 != null && l2 != null) {
                    sum = l1.val + l2.val + carry;
                    l1 = l1.next;
                    l2 = l2.next;
                } else if (l1 != null && l2 == null) {
                    sum = l1.val + carry;
                    l1 = l1.next;
                } else {
                    sum = l2.val + carry;
                    l2 = l2.next;
                }

                carry = sum / 10;
                num = sum % 10;

                tail.next = new ListNode(num);
                tail = tail.next;
            }
            if (carry != 0) {
                tail.next = new ListNode(1);
            }
            return result.next;
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

        ListNode result2 = solution.addTwoNumbers(l4, l3);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }
    }
}
