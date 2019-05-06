package test;

import org.apache.commons.lang3.RandomUtils;
import java.util.*;

public class TestStream {

    public static void main(String[] args){

        List<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<25; i++){
            Random random = new Random();
            list.add(RandomUtils.nextInt(1,1000));
        }

        for (Integer i : list){
            System.out.print(i+", ");
        }

        Optional<Integer> max = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return 1;
                }else if (o1 == o2){
                    return  0;
                }else {
                    return -1;
                }
            }
        });

        System.out.println();
        System.out.println(max.get());

    }


}
