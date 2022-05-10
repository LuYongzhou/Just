package com.lu.common.dto;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/2
 */
@Data
@ApiModel(description = "用户DTO")
public class UserDto implements Serializable {

    private static final long serialVersionUID = -8711222298804942743L;

    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("登陆名")
    private String accessName;
    @ApiModelProperty("姓名")
    private String userName;
    @ApiModelProperty("描述")
    private String describe;
    @ApiModelProperty("手机号")
    private String mobileNo;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("密码生效标识 1:生效;0失效")
    private Integer passwordEnable;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("生效标识 1:生效;0失效")
    private Integer enable;
    @ApiModelProperty("操作人")
    private String operateUser;
    @ApiModelProperty("删除状态 2：已删除;0或null未删除")
    private Integer deleteStatus;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifyTime;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
