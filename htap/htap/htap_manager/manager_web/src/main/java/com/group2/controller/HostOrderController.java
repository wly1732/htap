package com.group2.controller;

import com.group2.pojo.HostOrder;
import com.group2.service.HostOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Controller
@RequestMapping("/hostOrder")
public class HostOrderController {

    @Autowired
    private HostOrderService hostOrderService;

    @ResponseBody
    @RequestMapping("/getHostOrderByOidAndHid")
    public Map<String, Object> getHostOrderByOidAndHid(Integer oid, Integer hid, Integer cid, Integer pid, String hoteladdress, Date wedding_time){
        PageInfo<HostOrder> pageInfo = hostOrderService.getHostOrderByOidAndHid(oid, hid, cid, pid,hoteladdress,wedding_time);

        Map<String, Object> map = new HashMap<>();
        map.put("rows", pageInfo.getList());
        map.put("total", pageInfo.getTotal());
        return map;
    }
}