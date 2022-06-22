package com.group2.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {

    @Delete("delete from t_role_menu where rid=#{rid}")
    int deleteRoleMenu(Integer rid);

    @Insert("insert into t_role_menu values(#{rid}, #{mid})")
    int addRoleMenu(@Param("rid") Integer rid, @Param("mid") Integer mid);
}
