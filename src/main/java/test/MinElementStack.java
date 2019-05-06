package test;

import org.apache.commons.lang3.RandomUtils;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的 min 函数。
 */
public class MinElementStack {

    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args){

        MinElementStack minElementStack = new MinElementStack();
        for (int i=0; i<30; i++){
            Integer randomElement = RandomUtils.nextInt(1,100);
            System.out.print("push e: "+randomElement+"\t");
            minElementStack.push(randomElement);
            System.out.println("min e:"+minElementStack.minElement());
        }

        minElementStack.printElements();

        for (int i=0; i<10; i++){
            Integer element = minElementStack.pop();
            System.out.print("pop e: "+element+"\t");
            System.out.println("min e:"+minElementStack.minElement());
        }

    }

    public Integer push(Integer e){

        if (minStack.isEmpty() || minStack.peek() > e){
            minStack.push(e);
        }

        return dataStack.push(e);
    }

    public Integer pop(){

        Integer e = dataStack.pop();
        if (!minStack.isEmpty() && (minStack.peek() == e)){
            minStack.pop();
        }
        return e;
    }

    public Integer minElement(){
        return minStack.peek();
    }

    public void printElements(){
        for (Integer e : dataStack){
            System.out.print(e+",");
        }
        System.out.println();
    }


}
