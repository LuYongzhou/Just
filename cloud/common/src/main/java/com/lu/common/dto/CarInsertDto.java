package com.lu.common.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
public class CarInsertDto implements Serializable {

    private static final long serialVersionUID = -8795062298804242743L;

    private Integer id;
    private String name;
    private String type;
    private Integer sitnum;
    private Integer cid;
    private Double price;
    private Integer number;
    private String picture;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
