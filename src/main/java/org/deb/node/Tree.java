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

}
