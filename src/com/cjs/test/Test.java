package com.cjs.test;

import com.cjs.arrays.Array;
import com.cjs.binary_search_tree.BST;
import com.cjs.linked_list.LinkedList;
import com.cjs.queue.ArrayQueue;
import com.cjs.queue.LinkedListQueue;
import com.cjs.queue.LoopQueue;
import com.cjs.stack.ArrayStack;
import com.cjs.stack.LinkedListStack;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        test.testArray();
//        test.testArrayStack();
//        test.testArrayQueue();
//        test.testLoopQueue();
//        test.testLinkedList();
//        test.testLikedListStack();
//        test.testLinkedListQueue();
        test.testBST();
    }
    //测试BST
    public void testBST(){
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
//        System.out.println(bst);
//        bst.preOrder();
//        System.out.println();
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        bst.levelOrder();
//        System.out.println();
    }
    //测试链表队列
    private void testLinkedListQueue(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enQueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.deQueue();
                System.out.println(queue);
            }
        }
    }
    //测试链表栈
    private void testLikedListStack(){
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
    //测试链表
    private void testLinkedList(){

        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
    //循环队列测试
    private void testLoopQueue(){
        LoopQueue<Integer> queue = new LoopQueue<>(5);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enQueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.deQueue();
                System.out.println(queue);
            }
        }
    }
    //数组队列测试
    private void testArrayQueue(){
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enQueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.deQueue();
                System.out.println(queue);
            }
        }
        System.out.println(queue.getFront());
    }
    //数组栈测试
    private void testArrayStack(){
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
    }
    //动态数组测试
    private void testArray(){
        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}
