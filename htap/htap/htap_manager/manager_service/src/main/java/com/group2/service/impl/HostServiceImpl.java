package com.group2.service.impl;


import com.group2.mapper.HostMapper;
import com.group2.pojo.Host;
import com.group2.pojo.HostCondition;
import com.group2.service.HostService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 */
@Service
public class HostServiceImpl implements HostService {

    @Autowired
    private HostMapper hostMapper;

    @Override
    public Host login(String hname, String hpwd) {
        return hostMapper.getHostByNameAndPwd(hname,hpwd);

    }

    @Override
    public int updateHostStrong(Integer hid, Integer strong) {
        return hostMapper.updateHostStrong(hid,strong);
    }

    @Override
    public int updateHostStatus(String ids, String status) {

        String[] idArr = ids.split(",");

        int i = 0;
        for(String id : idArr){
            i = hostMapper.updateHostStatus(Integer.parseInt(id), status);
        }
        return i;
    }

    @Override
    public int addHost(Host host) {

        host.setNum(0);
        host.setStrong("0");
        host.setStatus("正常");
        host.setStarttime(new Date());

        return hostMapper.addHost(host);
    }

    @Override
    public PageInfo<Host> getHostByCondition(HostCondition hostCondition, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Host> list = hostMapper.getHostByCondition(hostCondition);

        return new PageInfo<>(list);
    }
}