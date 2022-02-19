package com.cjs.test;

import com.cjs.segment_tree.SegmentTree;

public class TestSegmentTree {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,-1,-2,-3};
        SegmentTree<Integer> segmentTree = new SegmentTree<Integer>(nums, Integer::sum);
        segmentTree.set(1,3);
        System.out.println(segmentTree.query(0,2));
    }
}
