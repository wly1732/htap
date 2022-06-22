package com.group2.controller;


import com.group2.pojo.HostPower;
import com.group2.service.HostPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 */
@Controller
@RequestMapping("/hostPower")
public class HostPowerController {

    @Autowired
    private HostPowerService hostPowerService;

    @ResponseBody
    @RequestMapping("/addHostPower")
    public String addHostPower(HostPower hostPower, String ids){
        int i = hostPowerService.addHostPower(ids, hostPower);
        return i > 0 ? "true" : "false";
    }
}
