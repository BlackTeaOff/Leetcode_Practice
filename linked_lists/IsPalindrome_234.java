package linked_lists;

public class IsPalindrome_234 {
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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }
            ListNode mid = head;
            ListNode end = head;

            // 双指针找中点
            while (end != null && end.next != null) {
                mid = mid.next;
                end = end.next.next;
            }

            // end != null 代表有奇数个节点, 中间的节点一定是对称的, 跳过
            if (end != null) {
                mid = mid.next;
            }

            // 反转后半部分链表, 反转完prev就是后半部分链表的头
            // 详见 ReverseList_206
            ListNode prev = null;
            while (mid != null) {
                ListNode nextTemp = mid.next;
                mid.next = prev;
                prev = mid;
                mid = nextTemp;
            }

            ListNode start = head;
            ListNode start2 = prev;

            while (start2 != null) {
                if (start.val != start2.val) {
                    return false;
                }
                start = start.next;
                start2 = start2.next;
            }
            return true;
        }

        ListNode temp = null; 
        int ok = 0;

        public boolean recursion(ListNode node) {
            if (node != null) {
                if (recursion(node.next) == false) {
                    return false;
                }
                if (ok == 1) {
                    return true;
                }
                if (temp.val != node.val) {
                    return false;
                } else {
                    if (temp == node || temp.next == node) {
                        ok = 1;
                    }
                    temp = temp.next;
                    return true;
                }
            } else {
                return true;
            }
        }

        public boolean isPalindrome2(ListNode head) {
            if (head.next == null) {
                return true;
            }

            temp = head;

            return recursion(head);
        }
    }
}
