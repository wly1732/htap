package com.group2.service;

import com.group2.pojo.Planner;
import com.github.pagehelper.PageInfo;

/**
 * @author lhp
 * @create 2021-08-23 14:05
 */
public interface PlannerService {

    PageInfo<Planner> getPlannerByCid(Integer cid, Integer pageNum, Integer pageSize);
}
