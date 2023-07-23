//package com.student.model;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletRequestWrapper;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Component;
//
//
//import java.io.IOException;
//@Component
//public class MyFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        Cookie[] cookie = req.getCookies();
//        boolean check = false;
//        for (Cookie c: cookie) {
//            if (c.getName().equals("test")){
//                check = true;
//
//        }
//        }
//        if (!check){
//            request = new HttpServletRequestWrapper(req){
//                @Override
//                public String getRequestURI() {
//                    return "/employee";
//                }
//            };
//        }
//
//        chain.doFilter(request,response);
//    }
//}
