package leetcode.google;

import leetcode.common.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
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
