package com.group2.controller;


import com.group2.pojo.Admin;
import com.group2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.jsp"; //重定向
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(String aname, String apwd, HttpSession session){

        Admin admin = adminService.login(aname, apwd);

        if(admin != null){
            session.setAttribute("admin", admin);
            return "true";
        }else{
            return "false";
        }
    }
}