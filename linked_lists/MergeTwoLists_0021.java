package linked_lists;

public class MergeTwoLists_0021 {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = new ListNode();
            ListNode tail = result;
            ListNode p1 = list1;
            ListNode p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    tail.next = p1;
                    tail = tail.next;
                    p1 = p1.next;
                    tail.next = null;
                } else {
                    tail.next = p2;
                    tail = tail.next;
                    p2 = p2.next;
                    tail.next = null;
                }
            }
            if (p1 != null) {
                while (p1 != null) {
                    tail.next = p1;
                    tail = tail.next;
                    p1 = p1.next;
                    tail.next = null;
                }
            } else if (p2 != null) {
                while (p2 != null) {
                    tail.next = p2;
                    tail = tail.next;
                    p2 = p2.next;
                    tail.next = null;
                }
            }
            return result.next;
        }

        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            ListNode result = new ListNode();
            ListNode tail = result;
            ListNode p1 = list1;
            ListNode p2 = list2;

            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    tail.next = p1;
                    tail = tail.next;
                    p1 = p1.next;
                } else {
                    tail.next = p2;
                    tail = tail.next;
                    p2 = p2.next;
                }
            }

            // 因为后面是升序, 所以直接接上就行
            tail.next = (p1 != null) ? p1 : p2;
            return result.next;
        }
    }
}
