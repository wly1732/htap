package com.group2.service;


import com.group2.pojo.Company;
import com.github.pagehelper.PageInfo;

/**
 * @author lhp
 * @create 2021-08-23 9:49
 */
public interface CompanyService {

    int updateCompany(Company company);

    int addCompany(Company company);

    PageInfo<Company> getCompanyByCondition(String cname, String status, String cnumOrder, Integer pageNum, Integer pageSize);
}
