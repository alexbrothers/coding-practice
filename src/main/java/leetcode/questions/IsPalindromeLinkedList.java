package leetcode.questions;

import leetcode.common.ListNode;

public class IsPalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode ahead = head;
        ListNode current = head;
        ListNode prev = null;
        while (ahead != null && ahead.next != null) {
            ahead = ahead.next.next;
            prev = current;
            current = current.next;
        }
        ListNode reversedHead;
        if (ahead == null) {
            reversedHead = reverse(current, prev);
        }
        else {
            reversedHead = reverse(current, null);
        }
        while (head != reversedHead && head.next != reversedHead) {
            if (head.val != reversedHead.val) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return head.val == reversedHead.val;
    }

    private ListNode reverse(ListNode node, ListNode previous) {
        ListNode next = node.next;
        node.next = previous;
        if (next == null) {
            return node;
        }
        else {
            return reverse(next, node);
        }
    }

}
