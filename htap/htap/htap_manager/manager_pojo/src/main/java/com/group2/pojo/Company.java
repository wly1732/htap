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
public class Company {
    private Integer cid;
    private String cpwd;
    private String cname;
    private String ceo;
    private String cphone;
    private String cmail;
    private Date starttime;
    private String status;
    private Integer cnum;
}
