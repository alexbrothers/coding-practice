package leetcode.questions;

import leetcode.common.ListNode;

public class SortLinkedList {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode right = getMid(head);
        ListNode sortedLeft = sort(head);
        ListNode sortedRight = sort(right);
        return merge(sortedLeft, sortedRight);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                current.next = node2;
                break;
            }
            if (node2 == null) {
                current.next = node1;
                break;
            }
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            }
            else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode ahead = head;
        ListNode behind = head;
        ListNode prev = null;
        while (ahead != null && ahead.next != null) {
            ahead = ahead.next.next;
            prev = behind;
            behind = behind.next;
        }
        prev.next = null;
        return behind;
    }

}
