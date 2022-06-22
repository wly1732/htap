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
public class HostOrder {
    private Integer oid;
    private Integer hid;
    private Integer cid;
    private Integer pid;
    private String hoteladdress;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date wedding_time;


}