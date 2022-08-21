package leetcode.questions;

import leetcode.common.ListNode;

public class RemoveDuplicatesOneLinkedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next;
                current = prev.next;
            }
            else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

}
