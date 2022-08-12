package leetcode.questions;

import leetcode.common.ListNode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return swapPairsHelper(head);
    }

    private ListNode swapPairsHelper(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode next = node.next;
        if (next == null) {
            return node;
        }
        ListNode ahead = swapPairsHelper(next.next);
        next.next = node;
        node.next = ahead;
        return next;
    }

}
