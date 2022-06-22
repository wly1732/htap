package com.group2.controller;

import com.group2.pojo.Company;
import com.group2.service.CompanyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhp
 * @create 2021-08-23 9:51
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ResponseBody
    @RequestMapping("/updateCompany")
    public String updateCompany(Company company){
        int i = companyService.updateCompany(company);
        return i > 0 ? "true" : "false";
    }

    @ResponseBody
    @RequestMapping("/addCompany")
    public String addCompany(Company company){
        int i = companyService.addCompany(company);
        return i > 0 ? "true" :"false";
    }

    @ResponseBody
    @RequestMapping("/getCompanyByCondition")
    public Map<String, Object> getCompanyByCondition(String cname, String status, String cnumOrder, Integer page, Integer rows){

        PageInfo<Company> pageInfo = companyService.getCompanyByCondition(cname, status, cnumOrder, page, rows);

        //前端要的是 total  和  rows
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }
}
