package linked_lists;

public class RemoveElements_203 {
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

    public static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return null;
            }

            while (head.val == val) {
                head = head.next;
                if (head == null) {
                    return null;
                }
            }

            ListNode curr = head;
            ListNode prev = null;

            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                } else {
                    prev = curr;
                }
                curr = curr.next;
            }

            return head;
        }
    }
}
