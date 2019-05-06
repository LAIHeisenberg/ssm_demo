package test;

import com.alibaba.fastjson.JSONArray;
import org.apache.poi.ss.formula.functions.T;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJsonObjToMap {

    public static void main(String[] args){
        List<A> list = new ArrayList<A>();
        for (int i=0; i<10; i++){
            char b = 'a';
            A a = new A(i, (char)(b+i)+"");
            list.add(a);
        }

        List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();

        for (A a : list){
            mapList.add(TestJsonObjToMap.<String,Object>bean2Map(a, A.class));
        }

        for (Map<String,Object> m : mapList){
            System.out.println(m.get("a")+"   :  "+m.get("b"));
        }

    }




    public static <K,V> Map<K,V> bean2Map(Object obj, Class clazz){
        Map<K,V> map = new HashMap<K, V>();
        try {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (int i=0; i<declaredFields.length; i++){
                Field f = declaredFields[i];
                f.setAccessible(true);
                map.put((K)f.getName(),(V)f.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



    static class A {
        int a;
        String b;
        public A(int a, String b){
            this.a = a;
            this.b = b;

        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }

}
