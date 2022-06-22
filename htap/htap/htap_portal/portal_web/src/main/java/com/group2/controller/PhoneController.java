package com.group2.controller;
import com.group2.utils.SmsUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**

 */
@Controller
public class PhoneController {

    @ResponseBody
    @RequestMapping("/phone")
    public String sendCode(String phonenumber, HttpSession session){

        //int code = (int)(Math.random()*9000 + 1000);  // [0,1)   [0,9000)   [1000,10000)
          int code =2624;
        //将验证码往session存一份，为了之后注册提交回来表单后要对比验证码
        session.setAttribute("code",code);

        try {
            String s = SmsUtils.sendSms(phonenumber, code + "");
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
