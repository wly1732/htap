package com.group2.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    private Integer hid;
    private String hname;
    private String hpwd;
    private String hphone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date starttime;
    private String status;
    private String strong;
    private Integer num;
    private HostPower hostPower; //级联属性
}