package test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegx {

    public static void main(String[] args) {

//        String sourceString = "p";
//        String regx = "[\u4e00-\u9fa5]";
//        String str = matchTargetString(sourceString,regx);
//        System.out.println("sourceString:"+sourceString+"targetString:"+str);
//        Integer a = null;
//        test1(a);

        System.out.println((int) 'a'+"  "+ (int)'A');
        System.out.println(camel2Underline("validStockNumForVacancyNewC"));
    }


    public static String camel2Underline(String camelString){
        StringBuffer sbf = new StringBuffer();
        for (int i=0; i<camelString.length(); i++){

            if (camelString.charAt(i) >= 'A' && camelString.charAt(i) <= 'Z'){
                sbf.append("_"+(char)(camelString.charAt(i) + 32));
            }else{
                sbf.append(camelString.charAt(i));
            }
        }

        return sbf.toString();
    }


    public static String matchTargetString(String sourceString,String regex){

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceString);
        String targetString = "";
        if (matcher.find()){
            //有匹配的字符串
            targetString = matcher.group();
        }else {
            System.out.println("未找到匹配项");
        }
        return targetString;
    }

    public static void test1(Integer n){
        int a = n;
        int b = n+3;
        System.out.println(b);
    }
}


