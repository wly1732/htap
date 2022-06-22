package com.group2.service.impl;


import com.group2.mapper.HostPowerMapper;
import com.group2.pojo.HostPower;
import com.group2.service.HostPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class HostPowerServiceImpl implements HostPowerService {

    @Autowired
    private HostPowerMapper hostPowerMapper;

    /**
     * 批量添加主持人权限
     * @param ids    多个主持人的编号
     * @param hostPower  主持人权限
     * @return
     */
    @Override
    public int addHostPower(String ids, HostPower hostPower) {

        String[] idArr = ids.split(",");

        int i = 0;
        for (String hid : idArr) {
            //1.先根据主持人的编号删除它的权限
            hostPowerMapper.deleteHostPower(Integer.parseInt(hid));

            //2.添加权限
            hostPower.setHostid(Integer.parseInt(hid));
            i = hostPowerMapper.addHostPower(hostPower);
        }

        return i;
    }
}