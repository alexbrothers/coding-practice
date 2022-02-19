package dailybyte.questions;

import dailybyte.common.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountNodesTest {

    private static CountNodes countNodes;

    @BeforeAll
    public static void setUp() {
        countNodes = new CountNodes();
    }

    @Test
    public void testNullTree() {
        assertEquals(0, countNodes.countNodes(null));
    }

    @Test
    public void testSingleNodeTree() {
        assertEquals(1, countNodes.countNodes(new TreeNode(2)));
    }

    @Test
    public void testMultiNodeTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        root.right = node5;

        assertEquals(6, countNodes.countNodes(root));
    }

}
