package com.group2.mapper;

import com.group2.pojo.HostOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 */
public interface HostOrderMapper{

    List<HostOrder> getHostOrderByOidAndHid(@Param("oid") Integer oid, @Param("hid") Integer hid);
}