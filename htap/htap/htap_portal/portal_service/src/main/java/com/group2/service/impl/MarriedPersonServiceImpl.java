package com.group2.service.impl;

import com.group2.mapper.MarriedMapper;
import com.group2.pojo.MarriedPerson;
import com.group2.service.MarriedPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MarriedPersonServiceImpl implements MarriedPersonService {
    @Autowired
    private MarriedMapper marriedMapper;
    @Override
    public int register(MarriedPerson marriedPerson) {
        marriedPerson.setRegdate(new Date());
        marriedPerson.setStatus("正常");
        return marriedMapper.addMarriedPerson(marriedPerson);
    }
}
