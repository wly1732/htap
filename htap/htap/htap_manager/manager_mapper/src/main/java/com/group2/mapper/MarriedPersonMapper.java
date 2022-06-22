package com.group2.mapper;

import com.group2.pojo.MarriedPerson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 */
public interface MarriedPersonMapper {

    List<MarriedPerson> getMarriedPersonByNameAndPhone(@Param("pname") String pname, @Param("pphone") String pphone);
}
