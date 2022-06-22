package com.group2.service.impl;

import com.group2.mapper.PlannerMapper;
import com.group2.pojo.Planner;
import com.group2.service.PlannerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class PlannerServiceImpl implements PlannerService {

    @Autowired
    private PlannerMapper plannerMapper;

    @Override
    public PageInfo<Planner> getPlannerByCid(Integer cid, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Planner> list = plannerMapper.getPlannerByCid(cid);

        return new PageInfo<>(list);
    }
}
