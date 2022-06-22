package com.group2.mapper;

import com.group2.pojo.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 */
public interface MenuMapper {

    @Delete("delete from t_menu where mid=#{mid}")
    int deleteMenu(Integer mid);

    @Update("update t_menu set mname=#{mname}, url=#{url}, mdesc=#{mdesc} where mid=#{mid}")
    int updateMenu(Menu menu);

    //根据某个菜单id去修改 它的 isparent 和 status
    @Update("update t_menu set isparent=#{isparent}, status=#{status} where mid=#{mid}")
    int updateMenuIsparentAndStatusByMid(@Param("mid") Integer mid,
                                         @Param("isparent") Integer isparent,
                                         @Param("status") Integer status);


    @Insert("insert into t_menu values(null,#{mname},#{pid},#{isparent},#{status},#{url},#{mdesc})")
    int addMenu(Menu menu);

    //根据父菜单id查询子菜单
    @Select("select * from t_menu where pid=#{pid}")
    List<Menu> getMenuByPid(Integer pid);

    //根据登录人的id和父菜单id查询菜单信息
    @Select("select * from t_menu where mid in(select mid from t_role_menu where rid in(select rid from t_admin_role where aid=#{aid})) and pid=#{pid}")
    List<Menu> getMenuByAidAndPid(@Param("aid") Integer aid, @Param("pid") Integer pid);

    //根据角色id查询它对应的子菜单
    @Select("select * from t_menu where mid in (select mid from t_role_menu where rid=#{rid}) and isparent=0  ")
    List<Menu> getChildMenuByRid(Integer rid);
}