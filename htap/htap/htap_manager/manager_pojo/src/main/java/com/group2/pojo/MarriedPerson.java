package com.group2.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarriedPerson {
    private Integer pid;
    private String pname;
    private String ppwd;
    private String pphone;
    private String pmail;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date marrydate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regdate; //register
    private String status; //正常  禁用
}
