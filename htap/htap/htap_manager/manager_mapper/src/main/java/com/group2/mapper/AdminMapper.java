package com.group2.mapper;

import com.group2.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 2z
 *
 */
public interface AdminMapper {

    //根据用户名和密码查询
    @Select("select * from t_admin where aname=#{aname} and apwd=#{apwd}")
    Admin getAdminByNameAndPwd(@Param("aname") String aname, @Param("apwd") String apwd);
}