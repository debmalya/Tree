package org.deb;

import org.deb.node.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtil {

	int[] traverseTree(Tree<Integer> t) {

		Queue<Tree<Integer>> bfTraversal = new LinkedList<>();
		List<Integer> bfList = new ArrayList<>();

		traverse(t, bfList, bfTraversal);

		int[] arr = new int[bfList.size()];
		for (int i = 0; i < bfList.size(); i++) {
			arr[i] = bfList.get(i);
		}
		return arr;
	}

	private void traverse(Tree<Integer> t, List<Integer> bfList, Queue<Tree<Integer>> bfTraversal) {
		while (t != null) {
			bfList.add(t.getValue());

			if (t.getLeft() != null) {
				bfTraversal.add(t.getLeft());
			}
			if (t.getRight() != null) {
				bfTraversal.add(t.getRight());
			} else if (t.getLeft() == null) {
				bfTraversal.add(null);
			}
			t = bfTraversal.remove();
		}
	}

	public Tree<Integer> invertTree(Tree<Integer> root) {
		swapNode(root);
		return root;
	}

	public void swapNode(Tree<Integer> root) {
		if (root != null) {
			swapNode(root.getLeft());
			swapNode(root.getRight());
			Tree<Integer> temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
	}

}
