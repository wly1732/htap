package com.group2.controller;

import com.group2.pojo.MarriedPerson;
import com.group2.service.MarriedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/marriedPerson")
public class MarriedPersonController {
    @Autowired
    private MarriedPersonService marriedPersonService;

    @RequestMapping("/register")
    public String register(MarriedPerson marriedPerson, String checkCode, HttpSession session, Model model) {
        String code = (int) session.getAttribute("code") + "";
        if (checkCode.equals(code)) {
            int i = marriedPersonService.register(marriedPerson);
            if (i > 0) {
                return "redirect:/index.jsp";
            } else {
                model.addAttribute("msg", "注册失败");
                return "forward:/register.jsp";
            }
        } else {
            model.addAttribute("msg", "验证码输入错误");
            return "forward:/register.jsp";
        }
    }
}
