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

	public boolean isTreeSymmetric(Tree<Integer> t) {
		Tree<Integer> original = t;
		String preOrder = leftOrder(t);
		String postOrder = rightOrder(original);
		return preOrder.equals(postOrder);
	}


	public String rightOrder(Tree<Integer> t){
		if (t!=null){
			return ""+rightOrder(t.right)+rightOrder(t.left)+t.value;
		}
		return " ";
	}

	public String leftOrder(Tree<Integer> t){
		if (t!=null){
			return ""+leftOrder(t.left)+leftOrder(t.right)+t.value;
		}
		return " ";
	}

}
