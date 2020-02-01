package org.deb.node;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {
    Tree<Integer> root = new Tree<>(0);

    @Test
    public void testIsTreeSymmetric() {
        fail("Not yet implemented");
    }

    @Test
    public void testMirrorEquals() {
        fail("Not yet implemented");
    }

    @Test
    public void restoreBinaryTree() {
        Tree<Integer> restoredTree = root.restoreBinaryTree(new int[]{4, 2, 1, 5, 3, 6}, new int[]{1, 2, 4, 3, 5, 6});
        assertTrue(restoredTree.value == 1);
        assertTrue(restoredTree.left.value == 2);
		assertTrue(restoredTree.left.left.value == 4);
		assertTrue(restoredTree.right.value == 3);
		assertTrue(restoredTree.right.left.value == 5);
		assertTrue(restoredTree.right.right.value == 6);
    }

    @Test
    public void createLeftNRightSubtree() {
        int[][] actual = root.createLeftNRightInorder(new int[]{4, 2, 1, 5, 3, 6}, new int[]{1, 2, 4, 3, 5, 6});
        assertArrayEquals(new int[]{4, 2}, actual[0]);
        assertArrayEquals(new int[]{5, 3, 6}, actual[1]);
        assertArrayEquals(new int[]{2, 4}, actual[2]);
        assertArrayEquals(new int[]{3, 5, 6}, actual[3]);

        actual = root.createLeftNRightInorder(new int[]{4, 2}, new int[]{2, 4});
        assertArrayEquals(new int[]{4}, actual[0]);
        assertArrayEquals(new int[]{}, actual[1]);
        assertArrayEquals(new int[]{4}, actual[2]);
        assertArrayEquals(new int[]{}, actual[3]);
    }
}
