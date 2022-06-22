package com.group2.service.impl;


import com.group2.mapper.MarriedPersonMapper;
import com.group2.pojo.MarriedPerson;
import com.group2.service.MarriedPersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class MarriedPersonServiceImpl implements MarriedPersonService {

    @Autowired
    private MarriedPersonMapper marriedPersonMapper;

    @Override
    public PageInfo<MarriedPerson> getMarriedPersonByNameAndPhone(String pname, String pphone, Integer pageNum, Integer pageSize) {

        //设置分页的信息
        PageHelper.startPage(pageNum, pageSize);

        List<MarriedPerson> list = marriedPersonMapper.getMarriedPersonByNameAndPhone(pname, pphone);

        return new PageInfo<>(list);
    }
}
