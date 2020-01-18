package org.deb;

import org.deb.node.Tree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TreeUtilTest {

    TreeUtil treeUtil = new TreeUtil();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void diameter() {

//       assertEquals(2,treeUtil.treeDiameter(10,new int[][]{{3,0},{3,4},{2,3},{3,1}}));
    }

    @Test
    public void traverseTree() {
        Tree<Integer> t = new Tree<>(1);
        t.setLeft(new Tree<>(2));
        t.setRight(new Tree<>(4));
        t.getLeft().setRight(new Tree<>(3));
        t.getRight().setLeft(new Tree<>(5));

        int[] expected = new int[]{1, 2, 4, 3, 5};
        int[] actual = treeUtil.traverseTree(t);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);

        t = new Tree<>(1);
        t.setLeft(new Tree<>(2));
        t.setRight(new Tree<>(4));
        t.getLeft().setRight(new Tree<>(3));
        t.getLeft().setLeft(new Tree<>(7));
        t.getRight().setLeft(new Tree<>(5));
        t.getRight().setRight(new Tree<>(11));

        expected = new int[]{1, 2, 4, 7, 3, 5, 11};
        actual = treeUtil.traverseTree(t);
        System.out.println(Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}