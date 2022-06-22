package com.group2.service.impl;

import com.group2.mapper.RoleMapper;
import com.group2.mapper.RoleMenuMapper;
import com.group2.pojo.Role;
import com.group2.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public int updateRole(Role role, String ids) {
        //1.修改角色
        int i = roleMapper.updateRole(role);

        //2.将 t_role_menu 表中 该角色对应的数据都删掉
        roleMenuMapper.deleteRoleMenu(role.getRid());

        //3.将本次新勾选的菜单id 添加到 t_role_menu表中
        if(ids != null && !ids.equals("")){
            String[] idArr = ids.split(",");
            for (String id : idArr) {

                roleMenuMapper.addRoleMenu(role.getRid(), Integer.parseInt(id));
            }
        }
        return i;
    }

    @Override
    public int addRole(Role role, String ids) {

        //1.添加角色, 并且返回主键id
        int i = roleMapper.addRole(role);

        //2.给role_menu表中添加本次角色对应的菜单信息
        if(ids != null && !ids.equals("")){

            //选中和半选中的菜单id
            String[] idArr = ids.split(",");

            for (String id : idArr) {
                roleMenuMapper.addRoleMenu(role.getRid(), Integer.parseInt(id));
            }
        }
        return i;
    }

    @Override
    public PageInfo<Role> getRoleByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> list = roleMapper.getRole();
        return new PageInfo<>(list);

        //  select * from t_role limit (pageNum-1)*pageSize,pageSize
        //   select count(*) from ( select * from t_role)
    }

    @Override
    public int deleteRole(String ids) {
        int i = 0;
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            //1.删除 t_role表中的数据
            i = roleMapper.deleteRole(Integer.parseInt(id));

            //2.删除 t_role_menu表中的数据
            roleMenuMapper.deleteRoleMenu(Integer.parseInt(id));
        }
        return i;
    }
}
