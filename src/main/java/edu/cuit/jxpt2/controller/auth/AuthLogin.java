package edu.cuit.jxpt2.controller.auth;

import jakarta.servlet.annotation.HandlesTypes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.objenesis.instantiator.annotations.Instantiator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AuthLogin implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if (url.contains("/login")) return true;
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("userid");
        if (obj != null) {
            return true;
        }
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}
