package leetcode.questions;

import leetcode.common.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddTwoNumbersTest {

    private static AddTwoNumbers addTwoNumbers;

    @BeforeAll
    public static void setUp() {
        addTwoNumbers = new AddTwoNumbers();
    }

    @Test
    public void testWithEvenListSizes() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node3.next = node4;

        ListNode result = addTwoNumbers.addTwoNumbers(node1, node3);

        assertEquals(4, result.val);
        assertEquals(6, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testWithUnevenListSizes() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;

        ListNode result = addTwoNumbers.addTwoNumbers(node1, node3);

        assertEquals(4, result.val);
        assertEquals(2, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testWithNullList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode result = addTwoNumbers.addTwoNumbers(node1, null);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);
    }

    @Test
    public void testWithCarry() {
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        node1.next = node2;

        ListNode result = addTwoNumbers.addTwoNumbers(node1, node3);

        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testWithCarryAtEnd() {
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(8);

        ListNode result = addTwoNumbers.addTwoNumbers(node1, node2);

        assertEquals(6, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

}
