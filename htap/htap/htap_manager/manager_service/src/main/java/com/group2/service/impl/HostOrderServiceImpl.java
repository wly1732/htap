package com.group2.service.impl;


import com.group2.mapper.HostOrderMapper;
import com.group2.pojo.HostOrder;
import com.group2.service.HostOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 */
@Service
public class HostOrderServiceImpl implements HostOrderService {

    @Autowired
    private HostOrderMapper hostOrderMapper;



    @Override
    public PageInfo<HostOrder> getHostOrderByOidAndHid(Integer oid, Integer hid, Integer cid, Integer pid, String hoteladdress, Date wedding_time) {
        List<HostOrder> list = hostOrderMapper.getHostOrderByOidAndHid(oid,hid);

        return new PageInfo<>(list);
    }
}