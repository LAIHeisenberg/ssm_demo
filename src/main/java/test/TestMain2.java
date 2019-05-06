package test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain2 {

    public static void main(String[] args){
//        String a = "我\b你2\r3\tqwe\frq\0were\r\nwDC";
//        System.out.println("原始字符串: "+a);
//        a = a.replaceAll("\b|\n|\r\n|\t|\f|\r|\0","");
//        System.out.println(a);

        int a = 1;
        double b = a;
        System.out.println("aa:" + b);

        String n = "1449089702,";
        String[] arr = n.split(",");
//        System.out.println(arr.length);
//        System.out.println(regexMatchString(n,"^[0-9]{10}$"));




        List<Double> list = Arrays.asList(1.2,1.3,0.0,0.0,5.0,39.1,34.2,12.5,1.9,0.0);

        sortDouble(list, "asc");

//        for (double d:list){
//            System.out.print(d+" ;");
//        }

        List<Integer> l2 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int totalCount = l2.size();
        int size = 4;
        int index  = 19;

        if(index >  totalCount){
            //起始index超过总数
            if(totalCount % size == 0){
                index = totalCount - size + 1;
            }else{
                index = totalCount - (totalCount % size) + 1;
            }
        }

        List<Integer> rows = l2.subList(index-1, totalCount);

        System.out.println(rows);

        int[] arr2 = new int[]{1,3,4,5,6,7,8,9,1,15};

        noRepetition(arr2);

    }



    public static String regexMatchString(String sourceString,String regex){

        String targetString = "";
//        if(StringUtils.isEmpty(sourceString) || StringUtils.isEmpty(regex)){
//            return targetString;
//        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceString);
        if (matcher.find()){
            //有匹配的字符串
            targetString = matcher.group();
        }
        return targetString;
    }

    public static void sortDouble(List<Double> list, final String order){

        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {

                int d = 1;
                if("desc".equals(order)){
                    d = -1;
                }
                if (o1 > o2){
                    return d;
                }else {
                    return -d;
                }
            }
        });

    }

    public static void noRepetition(int[] arr){
        Set<Integer> set = new HashSet<Integer>();
        Integer repeatNum = null;
        for(int i : arr){
            if (set.contains(i)){
                repeatNum = i;
                break;
            }
            set.add(i);
        }
        System.out.println("出现两次的数字: "+repeatNum);
    }

}
