package com.group2.mapper;


import com.group2.pojo.Planner;

import java.util.List;

/**
 *
 */
public interface PlannerMapper {

    List<Planner> getPlannerByCid(Integer cid);
}
