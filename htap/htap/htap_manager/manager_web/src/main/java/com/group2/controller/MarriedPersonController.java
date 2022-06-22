package com.group2.controller;

import com.group2.pojo.MarriedPerson;
import com.group2.service.MarriedPersonService;
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
@RequestMapping("/marriedPerson")
public class MarriedPersonController {

    @Autowired
    private MarriedPersonService marriedPersonService;

    @ResponseBody
    @RequestMapping("/getMarriedPersonByNameAndPhone")
    public Map<String, Object> getMarriedPersonByNameAndPhone(String pname, String pphone, Integer page, Integer rows){
        PageInfo<MarriedPerson> pageInfo = marriedPersonService.getMarriedPersonByNameAndPhone(pname, pphone, page, rows);

        Map<String, Object> map = new HashMap<>();
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return map;
    }
}
