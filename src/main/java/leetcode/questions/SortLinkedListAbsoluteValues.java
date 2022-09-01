package leetcode.questions;

import leetcode.common.ListNode;

public class SortLinkedListAbsoluteValues {

    public ListNode sortLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode newTail = head;
        ListNode current = head.next;
        head.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            if (current.val < 0) {
                current.next = newHead;
                newHead = current;
            }
            else {
                newTail.next = current;
                newTail = newTail.next;
            }
            current = next;
        }
        return newHead;
    }

}
