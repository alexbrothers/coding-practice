package leetcode.questions;

import leetcode.common.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int count = listLength(head);
        k = k % count;
        ListNode behind = head;
        ListNode ahead = head;
        while (k > 0) {
            ahead = ahead.next;
            k--;
        }
        while (ahead.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        ahead.next = head;
        ListNode newHead = behind.next;
        behind.next = null;
        return newHead;
    }

    private int listLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}
