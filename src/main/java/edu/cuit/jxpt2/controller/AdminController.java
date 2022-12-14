package edu.cuit.jxpt2.controller;

import edu.cuit.jxpt2.entity.Admin;
import edu.cuit.jxpt2.mapper.SchoolMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.cuit.jxpt2.entity.School;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final Admin admin;


    public AdminController(Admin admin) {
        this.admin = admin;
    }


    @GetMapping("/info")
    @ResponseBody
    public Admin getAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            admin.setId((Integer) session.getAttribute("id"));
            admin.setName((String) session.getAttribute("username"));
            if (admin.getId() == null) return null;
            return admin;
        } catch (NullPointerException nullPointerException) {
            return null;
        }
    }
}
