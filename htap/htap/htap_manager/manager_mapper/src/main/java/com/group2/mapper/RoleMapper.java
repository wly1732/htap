package com.group2.mapper;

import com.group2.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Update("update t_role set rname=#{rname}, rdesc=#{rdesc} where rid=#{rid}")
    int updateRole(Role role);

    //Option这个注解就可以设置主键返回给对象的那个属性
    @Options(useGeneratedKeys = true, keyProperty = "rid")
    @Insert("insert into t_role values(null,#{rname},#{rdesc})")
    int addRole(Role role);

    @Select("select * from t_role")
    List<Role> getRole();

    @Delete("delete from t_role where rid=#{rid}")
    int deleteRole(int rid);
}
