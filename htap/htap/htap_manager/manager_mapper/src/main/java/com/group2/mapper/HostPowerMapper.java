package com.group2.mapper;

import com.group2.pojo.HostPower;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 */
public interface HostPowerMapper {

    //根据主持人id删除他对应的权限
    @Delete("delete from t_host_power where hostid=#{hid}")
    int deleteHostPower(Integer hid);

    //给权限表添加权限
    @Insert("insert into t_host_power values(null,#{hpstart},#{hpstartBeigindate}," +
            "#{hpstartEnddate},#{hpOrderPower},#{hpstartBegintime},#{hpstartEndtime}," +
            "#{hpdiscount},#{hpDisStarttime},#{hpDisEndtime},#{hpprice},#{hcosts},#{hostid})")
    int addHostPower(HostPower hostPower);
}
