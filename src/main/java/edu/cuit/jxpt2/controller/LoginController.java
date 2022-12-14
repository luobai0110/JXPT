package edu.cuit.jxpt2.controller;


import edu.cuit.jxpt2.interf.People;
import edu.cuit.jxpt2.servise.LoginImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final LoginImpl loginImpl;



    public LoginController(LoginImpl loginImpl) {
        this.loginImpl = loginImpl;
    }

    @PostMapping
    public ModelAndView login(@RequestParam(name = "userid") String userid,
                              @RequestParam(name = "passwd") String password,
                              @RequestParam(name = "identity") String identity,
                              @RequestParam(name = "remember", required = false)  String[] re,
                              HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        People people = loginImpl.login(Integer.valueOf(userid), password, identity);
        if (people != null) {
            session.setAttribute("userid", people.getId());
            session.setAttribute("identity", identity);
            if (re[0] == null) session.setAttribute("auto",false);
            modelAndView.setViewName("home");
            if (re[0]  != null && re[0].equals("true")) {
                session.setAttribute("username", people.getName());
                session.setAttribute("passwd", people.getPasswd());
                session.setAttribute("auto",true);
            }
            if (identity.equals("admin")) {
                modelAndView.setViewName("admin");
                return modelAndView;
            } else if (identity.equals("teacher")) {
                modelAndView.setViewName("teacher");
                return modelAndView;
            }

            return modelAndView;
        }
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }
//    自动登录
    @GetMapping
    public ModelAndView autoLogin(HttpServletRequest request, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("login");
//        验证是否为第一次登录
        if (httpSession.getAttribute("userid") == null) return modelAndView;
        httpSession = request.getSession();
        Boolean auto = null;
        if (httpSession.getAttribute("auto")!=null) auto = (boolean) httpSession.getAttribute("auto");
        if (Boolean.FALSE.equals(auto)) return modelAndView;
        Integer userId = (Integer) httpSession.getAttribute("userid");
        String passwd = (String) httpSession.getAttribute("passwd");
        String identity = (String) httpSession.getAttribute("identity");
        if (loginImpl.login(userId, passwd, identity) != null) {
            modelAndView.setViewName(identity);
        }
        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("index");
    }
}
