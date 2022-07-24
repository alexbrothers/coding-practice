package leetcode.google;

import leetcode.common.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            throw new IllegalArgumentException();
        }
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + ((right - left) / 2);
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid + 1, right);
        return mergeLists(leftList, rightList);
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                prev.next = list2;
                break;
            }
            if (list2 == null) {
                prev.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            }
            else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        return dummy.next;
    }

}
