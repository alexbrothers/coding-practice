package leetcode.questions;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

public class SortedListToBST {

    class HeadWrapper {
        ListNode head;

        HeadWrapper(ListNode head) {
            this.head = head;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTHelper(new HeadWrapper(head), 0, count(head));
    }

    private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    private TreeNode sortedListToBSTHelper(HeadWrapper headWrapper, int left, int right) {
        if (left > right || headWrapper.head == null) {
            return null;
        }
        int mid = left + ((right - left) / 2);
        TreeNode leftTree = sortedListToBSTHelper(headWrapper, left, mid - 1);
        TreeNode current = new TreeNode(headWrapper.head.val);
        headWrapper.head = headWrapper.head.next;
        current.left = leftTree;
        TreeNode rightTree = sortedListToBSTHelper(headWrapper, mid + 1, right);
        current.right = rightTree;
        return current;
    }

}
