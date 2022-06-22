package com.group2.service;

import com.group2.pojo.Host;
import com.group2.pojo.HostCondition;
import com.github.pagehelper.PageInfo;

/**
 */
public interface HostService {
    Host login(String hname,String hpwd);
    int updateHostStrong(Integer hid, Integer strong);

    /**
     * 修改主持人状态
     * @param ids   多个主持人id   1,2,3
     * @param status 状态
     * @return
     */
    int updateHostStatus(String ids, String status);

    /**
     * 添加主持人
     * @param host
     * @return
     */
    int addHost(Host host);

    //分页条件查询主持人
    PageInfo<Host> getHostByCondition(HostCondition hostCondition, Integer pageNum, Integer pageSize);
}
