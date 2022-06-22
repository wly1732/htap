package com.group2.controller;

import com.group2.pojo.Role;
import com.group2.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller //告诉SpringMVC容器，我这个类要交给容器管理，并且我是一个控制层
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping("/deleteRole")
    public String deleteRole(String ids){
        int i = roleService.deleteRole(ids);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/updateRole")
    public String updateRole(Role role, String ids){
        int i = roleService.updateRole(role, ids);
        return i > 0 ? "true" : "false";
    }


    @ResponseBody
    @RequestMapping("/addRole")
    public String addRole(Role role, String ids){
        int i = roleService.addRole(role, ids);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/getRoleByPage")
    public Map<String, Object> getRoleByPage(Integer page, Integer rows){
        PageInfo<Role> pageInfo = roleService.getRoleByPage(page, rows);
        Map<String, Object> map = new HashMap<>();
        map.put("total",pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
