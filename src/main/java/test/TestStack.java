package test;

import java.util.*;

public class TestStack {

    static Map<String,String> map;

    static {
        map = new HashMap();
        map.put("(",")");
        map.put("{","}");
        map.put("[","]");

    }

    public static void main(String[] args){
        String str = "(){}[]{{}{}{[";
        System.out.println(validParentheses(str));
    }


    public static boolean validParentheses(String str){

        Stack<String> stack = new Stack<>();

        for (int i=0; i<str.length(); i++){
            String c = str.charAt(i) + "";
            if (map.keySet().contains(c)){
                stack.push(c);
            }else {
                if(c.equals(map.get(stack.peek()))){
                    System.out.println(stack.pop()+" "+c);
                }else {
                    System.out.println("error: "+c);
                    return false;
                }
            }
        }

        return stack.empty();
    }

}
