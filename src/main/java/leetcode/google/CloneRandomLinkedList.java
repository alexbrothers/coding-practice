package leetcode.google;

import java.util.HashMap;
import java.util.Map;

public class CloneRandomLinkedList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        return copyRandomHelper(head, new HashMap<>());
    }

    private Node copyRandomHelper(Node node, Map<Node, Node> clones) {
        if (node == null) {
            return null;
        }
        if (clones.containsKey(node)) {
            return clones.get(node);
        }
        Node clone = new Node(node.val);
        clones.put(node, clone);
        clone.next = copyRandomHelper(node.next, clones);
        clone.random = copyRandomHelper(node.random, clones);
        return clone;
    }

}
