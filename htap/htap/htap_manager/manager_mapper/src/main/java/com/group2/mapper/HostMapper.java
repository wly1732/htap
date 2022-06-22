package com.group2.mapper;


import com.group2.pojo.Host;
import com.group2.pojo.HostCondition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author 2z
 *
 */
public interface HostMapper {
    @Select("select * from t_host where hname=#{hname} and hpwd=#{hpwd}")
    Host getHostByNameAndPwd(@Param("hname") String hname,@Param("hpwd") String hpwd);

    /**
     * 修改主持人权重
     * @param hid 主持人编号
     * @param strong 新的权重
     * @return
     */
    @Update("update t_host set strong=#{strong} where hid=#{hid}")
    int updateHostStrong(@Param("hid") Integer hid, @Param("strong") Integer strong);


    /**
     * 修改主持人状态
     * @param hid   主持人编号
     * @param status 状态
     * @return
     */
    @Update("update t_host set status=#{status} where hid=#{hid}")
    int updateHostStatus(@Param("hid") Integer hid, @Param("status") String status);

    /**
     * 添加主持人
     * @param host 主持人
     * @return
     */
    @Insert("insert into t_host values(null, #{hname}, #{hpwd}, #{hphone}, #{starttime}, #{status}, #{strong}, #{num})")
    int addHost(Host host);

    //根据条件查询主持人信息
    List<Host> getHostByCondition(HostCondition hostCondition);
}
