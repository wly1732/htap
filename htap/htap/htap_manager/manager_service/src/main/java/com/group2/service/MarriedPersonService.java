package com.group2.service;

import com.group2.pojo.MarriedPerson;
import com.github.pagehelper.PageInfo;

/**
 */
public interface MarriedPersonService {

    PageInfo<MarriedPerson> getMarriedPersonByNameAndPhone(String pname, String pphone, Integer pageNum, Integer pageSize);
}
