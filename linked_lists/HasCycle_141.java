package linked_lists;

public class HasCycle_141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = p1;

            // 里面的第一个if可以放到while里
            // while (fast != null && fast.next != null)
            while (p1 != null) {
                p1 = p1.next;
                if (p1 == null) {
                    return false;
                }
                p1 = p1.next;
                if (p1 == p2) {
                    return true;
                }
                p2 = p2.next;
            }
            return false;
        }
    }
}
