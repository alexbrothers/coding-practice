package leetcode.google;

import leetcode.common.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            throw new IllegalArgumentException();
        }
        ListNode ahead = head;
        ListNode behind = head;
        while (n > 0) {
            ahead = ahead.next;
            n--;
        }
        if (ahead == null) {
            return behind.next;
        }
        while (ahead.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        behind.next = behind.next.next;
        return head;
    }

}
