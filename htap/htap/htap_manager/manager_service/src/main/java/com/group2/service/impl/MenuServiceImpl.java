package com.group2.service.impl;
import com.group2.mapper.MenuMapper;
import com.group2.pojo.Menu;
import com.group2.pojo.TreeResult;
import com.group2.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 */
@Service
public class  MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<TreeResult> getAllMenu() {
        List<TreeResult> list = getMenuByParentId(0);
        return list;
    }

    /**
     * 根据父id去查询它的子菜单的方法
     * @param pid  父id
     * @return
     */
    private List<TreeResult> getMenuByParentId(Integer pid){ // 0
        List<Menu> list = menuMapper.getMenuByPid(pid);
        List<TreeResult> resultList = new ArrayList<>();

        for (Menu menu : list) {
            TreeResult t = new TreeResult();
            t.setId(menu.getMid());
            t.setText(menu.getMname());
            t.setState(menu.getStatus() == 1 ? "open" : "closed");
            Map<String,Object> map = new HashMap<>();
            map.put("url", menu.getUrl());
            map.put("isparent", menu.getIsparent());
            t.setAttributes(map);

            //对当前遍历到的这个菜单节点进行判断，判断他是否是父菜单
            //如果它是父菜单的话，我们还要查询它的子菜单，并且设置到它的children属性中去
            if(menu.getIsparent() == 1){
                //根据当前菜单的编号查询它的子菜单
                List<TreeResult> childrenList = getMenuByParentId(menu.getMid());
                t.setChildren(childrenList);
            }
            resultList.add(t);
        }
        return resultList;
    }

    @Override
    public int deleteMenu(Integer mid, Integer pid) {

        //1.先删除菜单
        int i = menuMapper.deleteMenu(mid);

        //2.删除完某个菜单后，要判断一下他的父亲还有没有子菜单了？
        List<Menu> list = menuMapper.getMenuByPid(pid);

        if(list == null || list.size() == 0){
            menuMapper.updateMenuIsparentAndStatusByMid(pid,0, 1);
        }

        //如果有的话，不做任何改变
        //如果没有的话，需要改父菜单的 isparent=0  status=1

        return i;
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int addMenu(Menu menu) {

        //注意：我们新加的一个菜单它肯定是儿子，因为它下面没有东西
        menu.setStatus(1);//打开
        menu.setIsparent(0); // 不是

        //1.将menu菜单信息添加到数据库中
        int i = menuMapper.addMenu(menu);

        //2.修改父菜单的isparent = 1（是父亲） 和 status = 0（关闭）
        menuMapper.updateMenuIsparentAndStatusByMid(menu.getPid(), 1, 0);
        return i;
    }

    @Override
    public List<TreeResult> getMenuByPid(Integer pid) {
        List<Menu> list = menuMapper.getMenuByPid(pid);
        List<TreeResult> resultList = new ArrayList<>();

        for (Menu menu : list) {
            TreeResult t = new TreeResult();
            t.setId(menu.getMid());
            t.setText(menu.getMname());
            t.setState(menu.getStatus() == 0 ? "closed" : "open");

            Map<String, Object> map = new HashMap<>();
            map.put("url", menu.getUrl());
            map.put("isparent", menu.getIsparent());
            map.put("mdesc", menu.getMdesc());
            map.put("pid", menu.getPid());
            t.setAttributes(map);
            resultList.add(t);
        }

        return resultList;
    }

    @Override
    public List<TreeResult> getMenuByAidAndPid(Integer aid, Integer pid) {

        List<Menu> list = menuMapper.getMenuByAidAndPid(aid, pid);

        List<TreeResult> resultList = new ArrayList<>();

        for (Menu menu : list) {
            TreeResult t = new TreeResult();

            t.setId(menu.getMid());
            t.setText(menu.getMname());
            t.setState(menu.getStatus() == 0 ? "closed" : "open");

            Map<String, Object> map = new HashMap<>();
            map.put("url",menu.getUrl()); //
            map.put("isparent",menu.getIsparent()); //是不是父菜单

            t.setAttributes(map);
            resultList.add(t);
        }
        return resultList;
    }

    @Override
    public List<TreeResult> getChildMenuByRid(Integer rid) {
        List<Menu> list = this.menuMapper.getChildMenuByRid(rid);
        List<TreeResult> resultList = new ArrayList();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            Menu menu = (Menu)var4.next();
            TreeResult t = new TreeResult();
            t.setId(menu.getMid());
            t.setText(menu.getMname());
            t.setState(menu.getStatus() == 1 ? "open" : "closed");
            Map<String, Object> map = new HashMap();
            map.put("url", menu.getUrl());
            map.put("isparent", menu.getIsparent());
            t.setAttributes(map);
            resultList.add(t);
        }

        return resultList;
    }
}
