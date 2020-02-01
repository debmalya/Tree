package org.deb.node;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    T value;

    /**
     * Constructor initializes value with x.
     *
     * @param x to initialize.
     */
    public Tree(T x) {
        value = x;
    }


    Tree<T> left;
    Tree<T> right;


    public T getValue() {
        return value;
    }

    public Tree<T> getLeft() {
        return left;
    }

    public Tree<T> getRight() {
        return right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setLeft(Tree<T> left) {
        this.left = left;
    }

    public void setRight(Tree<T> right) {
        this.right = right;
    }

    public boolean isTreeSymmetric(Tree<Integer> t) {
        Tree<Integer> original = t;
        String preOrder = leftOrder(t);
        String postOrder = rightOrder(original);
        return preOrder.equals(postOrder);
    }


    public String rightOrder(Tree<Integer> t) {
        if (t != null) {
            return "" + rightOrder(t.right) + rightOrder(t.left) + t.value;
        }
        return " ";
    }

    public String leftOrder(Tree<Integer> t) {
        if (t != null) {
            return "" + leftOrder(t.left) + leftOrder(t.right) + t.value;
        }
        return " ";
    }

    int kthSmallestInBST(Tree<Integer> t, int k) {
        List<Integer> collection = new ArrayList<>();
        printTree(t, collection, k);
        return collection.get(k - 1);
    }

    void printTree(Tree<Integer> root, List<Integer> collection, int k) {
        if (collection.size() == k) {
            return;
        }
        if (root != null) {
            printTree(root.left, collection, k);
            collection.add(root.value);
            printTree(root.right, collection, k);
        }
    }

    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        if (isIdentical(t1, t2)) {
            return true;
        }

        return (isSubtree(t1.left, t2) || isSubtree(t1.right, t2));


    }

    boolean isIdentical(Tree<Integer> t1, Tree<Integer> t2) {
        return inOrder(t1, t2);
    }


    boolean inOrder(Tree<Integer> t1, Tree<Integer> t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 != null && t2 != null && t1.value.equals(t2.value)) {
            return inOrder(t1.left, t2.left) && inOrder(t1.right, t2.right);
        }
        return false;
    }

    Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
        Tree<Integer> root = null;
        if (inorder.length > 0 && preorder.length > 0) {
            root = new Tree<>(preorder[0]);
            int[][] transformation = createLeftNRightInorder(inorder, preorder);
            root.left = createSubTree(root.left, transformation[0], transformation[2]);
            root.right = createSubTree(root.right, transformation[1], transformation[3]);
        }
        return root;
    }

    private Tree<Integer> createSubTree(Tree<Integer> root, int[] inorder, int[] preorder) {
        if (root == null) {
        	if (inorder.length >0 && preorder.length > 0) {
				root = new Tree<>(preorder[0]);
				int[][] transformation = createLeftNRightInorder(inorder, preorder);
				root.left = createSubTree(root.left, transformation[0], transformation[2]);
				root.right = createSubTree(root.right, transformation[1], transformation[3]);
			}
        }
        return root;
    }

    public int[][] createLeftNRightInorder(int[] inorder, int[] preorder) {
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                index = i;
                break;
            }
        }

        int[] leftInOrder = new int[index];
        int[] leftPreorder = new int[index];
        System.arraycopy(inorder, 0, leftInOrder, 0, index);
        System.arraycopy(preorder, 1, leftPreorder, 0, index);
        int[] rightInOrder = new int[inorder.length - index - 1];
        int[] rightPreOrder = new int[inorder.length - index - 1];
        System.arraycopy(inorder, index + 1, rightInOrder, 0, inorder.length - index - 1);
        System.arraycopy(preorder, index + 1, rightPreOrder, 0, inorder.length - index - 1);
        return new int[][]{leftInOrder, rightInOrder, leftPreorder, rightPreOrder};
    }


}
