package dailybyte.questions;

import dailybyte.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectingLists {

    /**
     * Given the reference to two linked lists, return the node at which they intersect.
     * Note: If the two lists never intersect, return null.
     *
     * Ex: Given the following linked lists...
     *
     * A: A1->A2
     *           \
     *            C1->C2->C3
     *           /
     * B: B1->B2
     * return a reference to node C1.
     */
    public ListNode intersectingLists(ListNode node1, ListNode node2) {
        Set<ListNode> visited = new HashSet<>();
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                if (visited.contains(node1)) {
                    return node1;
                }
                visited.add(node1);
                node1 = node1.next;
            }
            if (node2 != null) {
                if (visited.contains(node2)) {
                    return node2;
                }
                visited.add(node2);
                node2 = node2.next;
            }
        }
        return null;
    }

}
