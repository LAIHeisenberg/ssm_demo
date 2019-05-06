package ssm.actions;


import org.springframework.web.servlet.ModelAndView;
import ssm.common.PageParam;

import java.util.Map;


public class BaseAction {

    private PageParam pageParam;
    private ModelAndView mav;
    private Map<String, Object> paramMap;


    protected void addModelAttributes(String addtributeName, Object attributeValue){
        if (mav == null){
            mav = new ModelAndView();
        }
        mav.addObject(addtributeName, attributeValue);
    }

    protected void setViewName(String viewName){
        mav.setViewName(viewName);
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public ModelAndView getModelAndView() {
        return mav;
    }

    public void setModelAndView(ModelAndView modelAndView) {
        this.mav = modelAndView;
    }

    public PageParam getPageParam() {
        return pageParam;
    }

    public void setPageParam(PageParam pageParam) {
        this.pageParam = pageParam;
    }

}
