package com.group2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 是easyui菜单树要的节点对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeResult {
    private Integer id;
    private String text;
    private String state;
    private Map<String, Object> attributes;
    private List<TreeResult> children;
}
