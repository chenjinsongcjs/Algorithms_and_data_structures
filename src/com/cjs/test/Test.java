package com.cjs.test;

import com.cjs.arrays.Array;
import com.cjs.queue.ArrayQueue;
import com.cjs.queue.LoopQueue;
import com.cjs.stack.ArrayStack;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
//        test.testArray();
//        test.testArrayStack();
//        test.testArrayQueue();
        test.testLoopQueue();
    }
    //循环队列测试
    public void testLoopQueue(){
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
    public void testArrayQueue(){
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
