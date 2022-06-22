package com.group2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 主持人权限类 === 主持人详情
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostPower {
    private Integer hpid;
    private String hpstart;

    //这个注解作用就是：页面传递过来的字符串日期，控制层方法要接收的时候，需要转为Date类型
    //通过这里注解指定的格式才能进行转换， 如果这里不指定转换格式，那就会报错！
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hpstartBeigindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hpstartEnddate;
    private String hpOrderPower; //是否是自添订单
    private String hpstartBegintime;
    private String hpstartEndtime;
    private Integer hpdiscount; //折扣
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hpDisStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hpDisEndtime;
    private Double hpprice;
    private Double hcosts;
    private Integer hostid;
}
