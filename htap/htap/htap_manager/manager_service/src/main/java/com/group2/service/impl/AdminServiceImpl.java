package com.group2.service.impl;

import com.group2.mapper.AdminMapper;
import com.group2.pojo.Admin;
import com.group2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String aname, String apwd) {
        return adminMapper.getAdminByNameAndPwd(aname, apwd);
    }
}
