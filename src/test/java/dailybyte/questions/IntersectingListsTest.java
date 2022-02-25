package dailybyte.questions;

import dailybyte.common.ListNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntersectingListsTest {

    private static IntersectingLists intersectingLists;

    @BeforeAll
    public static void setUp() {
        intersectingLists = new IntersectingLists();
    }

    @Test
    public void testNullHeads() {
        assertNull(intersectingLists.intersectingLists(null, null));
    }

    @Test
    public void testOneNullHead() {
        assertNull(intersectingLists.intersectingLists(null, new ListNode(1)));
    }

    @Test
    public void testNonIntersectingListsWithDifferentValues() {
        ListNode head1 = new ListNode(1, new ListNode(3));
        ListNode head2 = new ListNode(2, new ListNode(4));

        assertNull(intersectingLists.intersectingLists(head1, head2));
    }

    @Test
    public void testNonIntersectingListsWithSameValues() {
        ListNode head1 = new ListNode(1, new ListNode(2));
        ListNode head2 = new ListNode(1, new ListNode(2));

        assertNull(intersectingLists.intersectingLists(head1, head2));
    }

    @Test
    public void testIntersectingLists() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node2;

        assertEquals(node2, intersectingLists.intersectingLists(node1, node4));
    }

    @Test
    public void testIntersectingListsAtEnd() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node3;

        assertEquals(node3, intersectingLists.intersectingLists(node1, node4));
    }
}
