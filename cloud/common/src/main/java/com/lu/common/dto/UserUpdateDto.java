package com.lu.common.dto;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
@Data
public class UserUpdateDto implements Serializable {

    private static final long serialVersionUID = -8722222298804902743L;

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

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
