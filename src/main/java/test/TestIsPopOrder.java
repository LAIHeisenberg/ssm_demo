package test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 检验出栈顺序是否正确
 *
 */
public class TestIsPopOrder {

    public static void main(String[] args){

        List<Integer> pushOrder = Arrays.asList(1,2,3,4,5);
        List<Integer> popOrder = Arrays.asList(4,5,3,2,1);
        Stack<Integer> stack = new Stack<>();
        System.out.println(isPopOrder(stack, pushOrder, popOrder));

    }

    public static boolean isPopOrder(Stack<Integer> stack, List<Integer> pushOrder, List<Integer> popOrder){

        int popIndex = 0;
        int pushIndex= 0;
        while (pushIndex < pushOrder.size()){
            stack.push(pushOrder.get(pushIndex));
            pushIndex ++;
            while (!stack.isEmpty() && (stack.peek() == popOrder.get(popIndex))){
                popIndex ++;
                stack.pop();
            }
        }

        if (stack.size() == (popOrder.size() - popIndex)){
            while (!stack.empty()){
                if (stack.peek() == popOrder.get(popIndex)){
                    popIndex ++;
                }
                stack.pop();
            }
        }

        return popIndex == popOrder.size();
    }

}
