package test;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 */
public class Stack2Queue {

    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();


    public static void main(String[] args){

        Stack2Queue stack2Queue = new Stack2Queue();
        for (int i=0; i<20; i++){
            stack2Queue.push(i);
        }

        for (int i=0; i<20; i++){
            System.out.print(stack2Queue.pop()+",");
        }
    }

    public Integer push(Integer n){
        return inStack.push(n);
    }

    public Integer pop(){

        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }

        return outStack.pop();
    }


}
