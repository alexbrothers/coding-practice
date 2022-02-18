package dailybyte.questions;

import dailybyte.common.TreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdenticalTreesTest {

    private static IdenticalTrees identicalTrees;

    @BeforeAll
    public static void setUp() {
        identicalTrees = new IdenticalTrees();
    }

    @Test
    public void testNullRoots() {
        assertTrue(identicalTrees.identicalTrees(null, null));
    }

    @Test
    public void testSameTrees() {
        TreeNode leftChild1 = new TreeNode(1);
        TreeNode rightChild1 = new TreeNode(3);
        TreeNode root1 = new TreeNode(2, leftChild1, rightChild1);

        TreeNode leftChild2 = new TreeNode(1);
        TreeNode rightChild2 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2, leftChild2, rightChild2);

        assertTrue(identicalTrees.identicalTrees(root1, root2));
    }

    @Test
    public void testDifferentStructuredTrees() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(18);
        node2.right = node3;
        node1.right = node2;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(18);
        node5.right = node6;
        node4.left = node5;

        assertFalse(identicalTrees.identicalTrees(node1, node4));
    }

    @Test
    public void testSameStructureDifferentValuesTrees() {
        TreeNode root1 = new TreeNode(2);
        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(1);
        root1.left = left1;
        root1.right = right1;

        TreeNode root2 = new TreeNode(2);
        TreeNode left2 = new TreeNode(1);
        TreeNode right2 = new TreeNode(3);
        root2.left = left2;
        root2.right = right2;

        assertFalse(identicalTrees.identicalTrees(root1, root2));
    }

}
