package com.zhtian.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;

public class FormLoginFilter extends PathMatchingFilter {  
    private String loginUrl = "home/home";
    private String successUrl = "order";
    @Override  
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {  
        if(SecurityUtils.getSubject().isAuthenticated()) {  
            return true;
        }  
        HttpServletRequest req = (HttpServletRequest) request;  
        HttpServletResponse resp = (HttpServletResponse) response;  
        if(isLoginRequest(req)) {  
            if("post".equalsIgnoreCase(req.getMethod())) {
                boolean loginSuccess = login(req);
                if(loginSuccess) {  
                    return redirectToSuccessUrl(req, resp);  
                }  
            }  
            return true;
        } else {
            saveRequestAndRedirectToLogin(req, resp);  
            return false;  
        }  
    }  
    private boolean redirectToSuccessUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {  
        WebUtils.redirectToSavedRequest(req, resp, successUrl);  
        return false;  
    }  
    private void saveRequestAndRedirectToLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {  
        WebUtils.saveRequest(req);  
        WebUtils.issueRedirect(req, resp, loginUrl);  
    }  
  
    private boolean login(HttpServletRequest req) {  
        String username = req.getParameter("username");  
        String password = req.getParameter("password");  
        try {  
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));  
        } catch (Exception e) {  
            req.setAttribute("shiroLoginFailure", e.getClass());  
            return false;  
        }  
        return true;  
    }  
    private boolean isLoginRequest(HttpServletRequest req) {  
        return pathsMatch(loginUrl, WebUtils.getPathWithinApplication(req));  
    }  
}   
