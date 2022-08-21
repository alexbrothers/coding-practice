package leetcode.questions;

import leetcode.common.ListNode;

public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        return reverse(head, k);
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode head = node;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return head;
            }
            node = node.next;
        }
        ListNode ahead = reverse(node, k);
        ListNode current = head;
        ListNode prev = null;
        while (current != node) {
            ListNode next = current.next;
            current.next = prev == null ? ahead : prev;
            prev = current;
            current = next;
        }
        return prev;
    }

}
