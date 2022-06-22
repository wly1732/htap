package com.group2.controller;


import com.group2.pojo.Admin;
import com.group2.pojo.Menu;
import com.group2.pojo.TreeResult;
import com.group2.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 根据角色id查询它对应的子菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/getChildMenuByRid")
    public List<TreeResult> getChildMenuByRid(Integer rid){
        return menuService.getChildMenuByRid(rid);
    }


    @ResponseBody
    @RequestMapping("/getAllMenu")
    public List<TreeResult> getAllMenu(){
        return menuService.getAllMenu();
    }

    @ResponseBody
    @RequestMapping("/deleteMenu")
    public String deleteMenu(Integer mid, Integer pid){
        int i = menuService.deleteMenu(mid, pid);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public String updateMenu(Menu menu){
        int i = menuService.updateMenu(menu);
        return i > 0 ? "true" : "false";
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    public String addMenu(Menu menu){
        int i = menuService.addMenu(menu);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/getMenuByPid")
    public List<TreeResult> getMenuByPid(@RequestParam(defaultValue = "0") Integer id){
        return menuService.getMenuByPid(id);
    }

    @ResponseBody
    @RequestMapping("/getMenus")
    public List<TreeResult> getMenus(@RequestParam(defaultValue = "0") Integer id, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        return menuService.getMenuByAidAndPid(admin.getAid(), id);
    }
}
