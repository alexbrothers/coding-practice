package leetcode.questions;

import leetcode.common.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int currentSum = 0;
            if (l1 != null) {
                currentSum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentSum += l2.val;
                l2 = l2.next;
            }
            currentSum += carry;
            if (currentSum > 9) {
                currentSum = currentSum % 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            current.next = new ListNode(currentSum);
            current = current.next;
        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }

}
