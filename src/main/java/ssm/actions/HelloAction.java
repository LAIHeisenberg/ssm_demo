package ssm.actions;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssm.common.PageParam;
import ssm.pojo.User;

import java.util.Map;

/**
 * Created by heisenberg on 16-8-28.
 */
@Controller
public class HelloAction extends BaseAction{

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String q1, String q2) {

        PageParam pageParam = getPageParam();

        System.out.println("pageNum: "+ pageParam.getPageNum() +"  pageSize: "+pageParam.getPageSize());
        System.out.println("q1: "+ q1 +" q2: "+q2);
        return "hello";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public void submit(User user){

        System.out.println(user);
        Map<String, Object> paramMap = getParamMap();

        for (Map.Entry<String,Object> entry : paramMap.entrySet()){
            System.out.println("paramMap: "+ entry.getKey() + " "+entry.getValue());
        }
        System.out.println(getPageParam().getPageNum()+" "+ getPageParam().getPageSize());

    }


    @RequestMapping(value = "/mybootstrap", method = RequestMethod.GET)
    public String myBootstrap(){
        return "mybootstrap";
    }

    @RequestMapping(value = "/comselect", method = RequestMethod.GET)
    public String comSelect(){
        return "comselect";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(){
        return "demo";
    }

    @ResponseBody
    @RequestMapping(value = "/comboSelectJson")
    public String getComboSelectJson(){

        JSONArray jsonArray = new JSONArray();

        String[] arr = new String[]{"选项1","选项2","选项3","选项4","选项1","选项2","选项3","选项4","选项1","选项2","选项3","选项4","选项1","选项2","选项3","选项4","选项1","选项2","选项3","选项4","选项1","选项2","选项3","选项4"};

        for (int i=0; i<arr.length; i++){

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("name", arr[i]);
            jsonObj.put("value", i);
            jsonArray.add(jsonObj);

        }

        return jsonArray.toJSONString();

    }

    @RequestMapping(value = "/myeasyui")
    public String myEasyUI(){
        return "myeasyui";
    }


    @RequestMapping(value = "/testParamPojo", method=RequestMethod.POST)
    public String testParamPojo(User user){

        return null;
    }


}
