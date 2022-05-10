package com.lu.common.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -8711222298804942743L;

    private Long id;
    private String accessName;
    private String userName;
    private String describe;
    private String mobileNo;
    private String email;
    private String password;
    private Integer passwordEnable;
    private String remark;
    private Integer enable;
    private String operateUser;
    private Integer deleteStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
