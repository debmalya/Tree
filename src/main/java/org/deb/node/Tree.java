package org.deb.node;

public class Tree<T> {
    T value;

    /**
     * Constructor initializes value with x.
     * @param x to initialize.
     */
    Tree(T x){
        value = x;
    }

    Tree<T> left;
    Tree<T> right;
    
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

	public boolean mirrorEquals(Tree<T> left, Tree<T> right) {
		if (left == null || right == null)
			return left == null && right == null;
		return left.value == right.value && mirrorEquals(left.left, right.right)
				&& mirrorEquals(left.right, right.left);
	}

}
