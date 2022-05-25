package com.lby.springcloud.ddd.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Order(0)
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) { // 针对swagger做的特殊处理
            HandlerMethod method = (HandlerMethod) handler;
            System.out.println("HandlerMethod:" + method.getClass().getName());
            System.out.println("getShortLogMessage:" + method.getShortLogMessage());
            System.out.println("method.getBeanType().getSimpleName():" + method.getBeanType().getSimpleName());
            System.out.println("method.getBeanType().getCanonicalName():" + method.getBeanType().getCanonicalName());
            System.out.println("method.getBeanType().getSimpleName():" + method.getBeanType().getSimpleName());
            
            
            boolean requiresLogin = method.hasMethodAnnotation(NeedLogin.class);
            if (requiresLogin) {
            	System.out.println("enter need login!!");
            	return false;
            }
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

}
