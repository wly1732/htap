package com.group2.service;

import com.group2.pojo.Menu;
import com.group2.pojo.TreeResult;

import java.util.List;

/**
 */
public interface MenuService {

    List<TreeResult> getAllMenu();

    int deleteMenu(Integer mid, Integer pid);

    int updateMenu(Menu menu);

    int addMenu(Menu menu);

    List<TreeResult> getMenuByPid(Integer pid);

    List<TreeResult> getMenuByAidAndPid(Integer aid, Integer pid);

    List<TreeResult> getChildMenuByRid(Integer rid);
}
