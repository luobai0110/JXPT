package edu.cuit.jxpt2.controller;


import edu.cuit.jxpt2.interf.People;
import edu.cuit.jxpt2.servise.LoginImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private final LoginImpl loginImpl;

    private final People people;


    public LoginController(LoginImpl loginImpl, People people) {
        this.loginImpl = loginImpl;
        this.people = people;
    }

    @PostMapping
    public ModelAndView login(@RequestParam(name = "userid") String userid,
                              @RequestParam(name = "passwd") String password,
                              @RequestParam(name = "identity") String identity,
                              @RequestParam(name = "remember", required = false) String[] re,
                              HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        if (loginImpl.login(Integer.valueOf(userid), password, identity) != null) {
            modelAndView.addObject(people);
            modelAndView.setViewName("home");
            if (re != null && re[0].equals("true")) {
                session.setAttribute("userid", userid);
                session.setAttribute("username", people.getName());
                session.setAttribute("passwd", people.getPasswd());
                session.setAttribute("identity", identity);
            }

            return modelAndView;
        }
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }

    @GetMapping
    public ModelAndView turnToLogin(HttpServletRequest request, @RequestParam(required = false) HttpSession httpSession) {
        HttpSession session = httpSession;
        ModelAndView modelAndView = new ModelAndView();
        if (httpSession == null) session = request.getSession();
        if (session.getAttribute("userid") != null &&  loginImpl.login(Integer.valueOf((String) session.getAttribute("userid")),
                (String) session.getAttribute("passwd")
                , (String) session.getAttribute("identity")) != null) {
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
