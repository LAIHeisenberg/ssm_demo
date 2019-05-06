package ssm.interceptor;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ssm.actions.BaseAction;
import ssm.common.PageParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        BaseAction baseAction = (BaseAction) handlerMethod.getBean();

        baseAction.setPageParam(new PageParam(pageNum,pageSize));

        ModelAndView modelAndView = new ModelAndView();
        baseAction.setModelAndView(modelAndView);


        Map<String, String[]> parameterMap = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()){

            String k = entry.getKey();
            String[] vArr = entry.getValue();
            for (String v : vArr){
                System.out.println(k + " : " + v);
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
