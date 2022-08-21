package leetcode.questions;

import leetcode.common.ListNode;

public class RemoveDuplicatesLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = findNextHead(head);
        return dummy.next;
    }

    private ListNode findNextHead(ListNode node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        if (node.next.val != node.val) {
            node.next = findNextHead(node.next);
            return node;
        }
        ListNode ahead = node;
        while (ahead != null && node.val == ahead.val) {
            ahead = ahead.next;
        }
        return findNextHead(ahead);
    }

}
