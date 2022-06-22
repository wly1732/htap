package com.group2.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Integer mid; //菜单编号
    private String mname; //菜单名字
    private Integer pid; //父菜单id
    private Integer isparent; //是不是父菜单 1-是 0-不是
    private Integer status; //表示菜单打开还是关闭，1-打开 0-关闭
    private String url; //菜单对应的链接地址
    private String mdesc;
}
