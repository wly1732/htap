package com.group2.controller;

import com.group2.pojo.Host;
import com.group2.pojo.HostCondition;
import com.group2.service.HostService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Controller
@RequestMapping("/host")
public class HostController {


    @Autowired
    private HostService hostService;
    @CrossOrigin  //跨域问题
    @ResponseBody
    @RequestMapping("/login")
    public String login(String hname,String hpwd){
        Host login=hostService.login(hname,hpwd);
        if(login !=null){
            return "true";
        }else {
            return "false";
        }
    }
    @ResponseBody //作用：就是将方法的返回值转为json字符串响应给前端
    @RequestMapping("/updateHostStrong")
    public String updateHostStrong(Integer hid, Integer strong){
        int i = hostService.updateHostStrong(hid, strong);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/updateHostStatus")
    public String updateHostStatus(String status, String ids){
        int i = hostService.updateHostStatus(ids, status);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping("/addHost")
    @ResponseBody
    public String addHost(Host host){
        int i = hostService.addHost(host);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/getHostByCondition")
    public Map<String,Object> getHostByCondition(Integer page, Integer rows, HostCondition hostCondition){
        PageInfo<Host> pageInfo = hostService.getHostByCondition(hostCondition, page, rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }
}
