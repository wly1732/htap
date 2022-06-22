package com.group2.controller;


import com.group2.pojo.Planner;
import com.group2.service.PlannerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 */
@Controller
@RequestMapping("/planner")
public class PlannerController {

    @Autowired
    private PlannerService plannerService;

    @ResponseBody
    @RequestMapping("/getPlannerByCid")
    public Map<String, Object> getPlannerByCid(Integer cid, Integer page, Integer rows){
        PageInfo<Planner> pageInfo = plannerService.getPlannerByCid(cid, page, rows);

        Map<String,Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());

        return map;
    }
}
