package com.group2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer rid;
    private String rname;
    private String rdesc;
}
