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
public class Planner {
    private Integer nid;
    private String nname;
    private String nphone;
    private Date addtime;
    private String status;
    private Integer cid;
    private Integer pnum;
    private Company company;
}
