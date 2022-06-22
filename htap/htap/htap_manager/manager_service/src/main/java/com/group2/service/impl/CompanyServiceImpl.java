package com.group2.service.impl;


import com.group2.mapper.CompanyMapper;
import com.group2.pojo.Company;
import com.group2.service.CompanyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public int updateCompany(Company company) {
        return companyMapper.updateCompany(company);
    }

    @Override
    public int addCompany(Company company) {
        company.setStarttime(new Date());
        company.setStatus("正常");
        company.setCnum(0);

        return companyMapper.addCompany(company);
    }

    @Override
    public PageInfo<Company> getCompanyByCondition(String cname, String status, String cnumOrder, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Company> list = companyMapper.getCompanyByCondition(cname, status, cnumOrder);

        return new PageInfo<>(list);
    }
}
