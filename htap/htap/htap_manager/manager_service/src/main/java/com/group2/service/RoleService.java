package com.group2.service;

import com.group2.pojo.Role;
import com.github.pagehelper.PageInfo;

public interface RoleService {

    int updateRole(Role role, String ids);

    int addRole(Role role, String ids);

    PageInfo<Role> getRoleByPage(Integer pageNum, Integer pageSize);

    int deleteRole(String ids);

}
