package com.group2.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 主持人条件查询的实体类？
 * 为什么要写它？
 * 因为条件太多了，写一个类后，在控制层就可以直接接收
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostCondition {
    private String hname; //主持人姓名
    private String status; //账号状态
    private String strongOrder; //权重的排序
    private String hpstart; //星推荐
    private Integer hpdiscount; //折扣
}
