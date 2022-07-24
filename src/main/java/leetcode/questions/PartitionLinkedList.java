package leetcode.questions;

import leetcode.common.ListNode;

public class PartitionLinkedList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLessThan = new ListNode(0);
        ListNode dummyGreaterThanOrEqualTo = new ListNode(0);
        ListNode lessThan = dummyLessThan;
        ListNode greaterThanOrEqualTo = dummyGreaterThanOrEqualTo;
        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x) {
                lessThan.next = head;
                lessThan = lessThan.next;
            }
            else {
                greaterThanOrEqualTo.next = head;
                greaterThanOrEqualTo = greaterThanOrEqualTo.next;
            }
            head = next;
        }
        if (dummyLessThan.next == null) {
            return dummyGreaterThanOrEqualTo.next;
        }
        if (dummyGreaterThanOrEqualTo.next == null) {
            return dummyLessThan.next;
        }
        lessThan.next = dummyGreaterThanOrEqualTo.next;
        return dummyLessThan.next;
    }

}
