package org.deb.node;

/**
 * To create a binary search tree with any comparable values (e.g. String,
 * Integer... whoever implements comparable).
 * 
 * @author debmalyajash
 *
 * @param <T>
 */
public class GenericNode<T extends Comparable<T>> {
	/**
	 * Left node
	 */
	private GenericNode<T> left;

	/**
	 * Right node
	 */
	private GenericNode<T> right;

	/**
	 * Value of current node
	 */
	private T value;

	/**
	 * 
	 * @return get left Node
	 */
	public GenericNode<T> getLeft() {
		return left;
	}

	/**
	 * Set left node
	 * 
	 * @param left
	 *            node to set.
	 */
	public void setLeft(GenericNode<T> left) {
		this.left = left;
	}

	/**
	 * 
	 * @return right node.
	 */
	public GenericNode<T> getRight() {
		return right;
	}

	/**
	 * 
	 * @param right
	 *            node to set.
	 */
	public void setRight(GenericNode<T> right) {
		this.right = right;
	}

	/**
	 * 
	 * @return node value.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 *            to set.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Find a node whose value matches the passed value.
	 * 
	 * @param root
	 *            node.
	 * @param value
	 *            to be checked.
	 * @return null if match not found, else the node containing matching value.
	 */
	public GenericNode<T> findNode(GenericNode<T> root, T value) {
		while (root != null) {

			T currValue = root.getValue();
			if (currValue == value) {
				break;
			}

			if (currValue.compareTo(value) > 0) {
				return findNode(root.getLeft(), value);
			} else {
				return findNode(root.getRight(), value);
			}

		}
		return root;
	}

	/**
	 * Add a node in proper place.
	 * 
	 * @param root
	 *            node.
	 * @param value
	 *            to be added.
	 * @return newly added node.
	 */
	private void addNode(GenericNode<T> root, T value) {
		if (root == null || root.value == null) {
			// This is the position to add value
			if (root == null){
				root = new GenericNode<T>();
			}
			root.value = value;
		} else if (root.value.compareTo(value) < 0) {
			// current node value is less so going to right.
			if (root.right == null) {
				root.right = new GenericNode<T>();
			}
			root.addNode(root.right, value);
		} else if (root.value.compareTo(value) > 0) {
			// current node value is more so going to left.
			if (root.left == null) {
				root.left = new GenericNode<T>();
			}
			root.addNode(root.left, value);
		}

	}

	/**
	 * Add a node in proper place.
	 * 
	 * @param root
	 *            node.
	 * @param value
	 *            to be added.
	 * @return newly added node.
	 */
	public void addNode(T value) {
		if (this.value == null) {
			// This is the position to add value
			this.value = value;
		} else if (this.value.compareTo(value) < 0) {
			// current node value is less so going to right.
			if (this.right == null) {
				this.right = new GenericNode<T>();
			}
			addNode(this.right, value);
		} else if (this.value.compareTo(value) > 0) {
			// current node value is more so going to left.
			if (this.left == null) {
				this.left = new GenericNode<T>();
			}
			addNode(this.left, value);
		}
	}
	/**
	 * 
	 * @param root
	 * @return pre order traversal String.
	 */
	public String preOrder(GenericNode<T> root){
		if (root != null){
			return ""+root.value+preOrder(root.left)+preOrder(root.right);
		}
		return "";
	}
	
	/**
	 * 
	 * @param root
	 * @return post order traversal String.
	 */
	public String postOrder(GenericNode<T> root){
		if (root != null){
			return postOrder(root.left)+postOrder(root.right)+root.value;
		}
		return "";
	}
	
	/**
	 * 
	 * @param root
	 * @return post order traversal String.
	 */
	public String inOrder(GenericNode<T> root){
		if (root != null){
			return inOrder(root.left)+root.value+inOrder(root.right);
		}
		return "";
	}
}
