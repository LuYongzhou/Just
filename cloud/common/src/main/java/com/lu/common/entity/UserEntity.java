package com.lu.common.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
@Data
public class UserEntity implements Serializable {

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
    private Date createTime;
    private Date modifyTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
