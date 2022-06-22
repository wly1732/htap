package com.group2.mapper;

import com.group2.pojo.MarriedPerson;
import org.apache.ibatis.annotations.Insert;



public interface MarriedMapper {
    @Insert("insert into t_married_person values(null, #{pname}, #{ppwd}, #{pphone}, #{pmail}, #{marrydate}, #{regdate}, #{status})")
    int addMarriedPerson(MarriedPerson marriedPerson);
}
