package com.twsihan.examples.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.twsihan.examples.anntation.AuthPassport;
import com.twsihan.examples.entities.UserInfo;

public class LocalInterceptor extends HandlerInterceptorAdapter
{


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

            // 没有声明需要权限，或者声明不验证权限
            if (authPassport == null || authPassport.validate() == false) {
                return true;
            } else {
                // 在这里实现自己的权限验证逻辑
                HttpSession session = request.getSession();
                UserInfo admin = (UserInfo) session.getAttribute("admin");
                if (admin == null) {
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        // 设置环境变量
        if (modelAndView != null) {
//            String realViewName = modelAndView.getViewName();
//            if (modelAndView.getModelMap().get("_master") != null) {
//                boolean _master = Boolean.valueOf(modelAndView.getModelMap().get("_master").toString());
//                if (_master) {
//                    modelAndView.setViewName("/common/master");
//                    modelAndView.addObject("contentName", realViewName);
//                }
//            }
            modelAndView.addObject("ctx", request.getContextPath());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
