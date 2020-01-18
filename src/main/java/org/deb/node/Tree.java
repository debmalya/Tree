package org.deb.node;

public class Tree<T> {
	T value;

	/**
	 * Constructor initializes value with x.
	 * 
	 * @param x
	 *            to initialize.
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

	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean isTreeSymmetric(Tree<T> t) {
		if (t != null) {
			return mirrorEquals(t.left, t.right);
		}
		return true;
	}

	boolean mirrorEquals(Tree<T> left, Tree<T> right) {
		if (left == null || right == null)
			return left == null && right == null;
		return left.value == right.value && mirrorEquals(left.left, right.right)
				&& mirrorEquals(left.right, right.left);
	}
}
