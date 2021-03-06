package com.cjs.data_structires.set_and_map;

import com.cjs.data_structires.binary_search_tree.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;
    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
