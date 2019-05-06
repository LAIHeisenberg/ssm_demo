package test;

import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestLinkedcaseinsensitivemap {

    public static void main(String[] args){

        List<Map> list = new ArrayList<Map>();
        LinkedCaseInsensitiveMap<String> linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap<String>();
        linkedCaseInsensitiveMap.put("from_place_name","北京");
        list.add(linkedCaseInsensitiveMap);
        for (Map<String,Object> map : list){
            System.out.println(map.get("from_place_name"));
        }

    }
}
