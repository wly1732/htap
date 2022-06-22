package com.group2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Integer aid;
    private String aname;
    private String apwd;
    private String aphone;
    private Date starttime;
}