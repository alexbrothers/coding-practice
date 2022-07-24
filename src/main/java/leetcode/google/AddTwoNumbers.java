package leetcode.google;

import leetcode.common.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int firstDigit = 0;
            int secondDigit = 0;
            if (l1 != null) {
                firstDigit = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                secondDigit = l2.val;
                l2 = l2.next;
            }
            int digit = firstDigit + secondDigit + carry;
            if (digit >= 10) {
                carry = 1;
                digit = digit % 10;
            }
            else {
                carry = 0;
            }
            prev.next = new ListNode(digit);
            prev = prev.next;
        }
        if (carry == 1) {
            prev.next = new ListNode(1);
        }
        return dummy.next;
    }

}
