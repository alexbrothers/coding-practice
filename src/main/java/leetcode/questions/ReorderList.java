package leetcode.questions;

import leetcode.common.ListNode;

public class ReorderList {

    class ReorderListHelper {
        ListNode prev;
        ListNode current;
        int count;
        int processed;
    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ReorderListHelper reorderListHelper = new ReorderListHelper();
        reorderListHelper.prev = dummy;
        reorderListHelper.current = head;
        reorderList(head, reorderListHelper);
    }

    private void reorderList(ListNode node, ReorderListHelper reorderListHelper) {
        if (node == null) {
            return;
        }
        reorderListHelper.count++;
        reorderList(node.next, reorderListHelper);
        if (reorderListHelper.processed < (reorderListHelper.count + 1) / 2) {
            ListNode first = reorderListHelper.current;
            reorderListHelper.current = reorderListHelper.current.next;
            reorderListHelper.processed++;
            reorderListHelper.prev.next = first;
            first.next = node;
            reorderListHelper.prev = node;
            node.next = null;
        }
    }

}
