package leetcode.questions;

import leetcode.common.ListNode;

public class ReverseLinkedListBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        int index = 1;
        while (index < left) {
            prev = current;
            current = current.next;
            index++;
        }
        ListNode newTail = current;
        ListNode[] result = reverse(current, index, right);
        prev.next = result[0];
        newTail.next = result[1];
        return dummy.next;
    }

    private ListNode[] reverse(ListNode node, int index, int right) {
        ListNode prev = null;
        while (index <= right) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            index++;
        }
        return new ListNode[]{prev, node};
    }

}
