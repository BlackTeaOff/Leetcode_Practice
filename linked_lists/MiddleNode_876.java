package linked_lists;

public class MiddleNode_876 {
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
        public ListNode middleNode(ListNode head) {
            ListNode mid = head;
            ListNode end = head;

            while (end != null && end.next != null) {
                mid = mid.next;
                end = end.next.next;
            }
            return mid;
        }
    }
}
