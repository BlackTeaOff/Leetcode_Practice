package linked_lists;

public class ReverseList_206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        };

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode result = new ListNode();
            ListNode temp = head;
            ListNode next;
            while (temp != null) {
                next = temp.next;
                temp.next = result.next;
                result.next = temp;
                temp = next;
            }
            return result.next;
        }

        public ListNode reverseList2(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = head;
            if (head.next == null) {
                return head;
            }
            ListNode curr = head.next;
            ListNode next = curr.next;
            prev.next = null;

            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            return prev;
        }

        public ListNode reverseList3(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;

            // head为空直接返回prev(null)
            while (curr != null) {
                // 确保head不为空, 在里面初始化next
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }
}
