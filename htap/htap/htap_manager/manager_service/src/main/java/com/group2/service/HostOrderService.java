package com.group2.service;

import com.group2.pojo.HostOrder;
import com.github.pagehelper.PageInfo;

import java.util.Date;

public interface HostOrderService {
    PageInfo<HostOrder> getHostOrderByOidAndHid(Integer oid, Integer hid, Integer cid, Integer pid, String hoteladdress, Date wedding_time);
}
