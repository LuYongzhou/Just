package com.lu.common.constant;


import com.alibaba.fastjson.JSON;
import com.lu.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ApiModel("公共返回体")
public class CommonRes<T> implements Serializable {
    private static final long serialVersionUID = -1L;

//    @ApiModelProperty(value = "返回码", notes = "200: 请求成功")
    private int code;

//    @ApiModelProperty("返回码描述")
    private String msg;

//    @ApiModelProperty("返回数据")
    private T data;

//    @ApiModelProperty(value = "总记录数", notes = "分页情况下使用")
    private String totalRecord;

    public static <T> CommonRes<T> SUCCESS(T data) {
        return new CommonRes<T>(200, "success", data, "");
    }

    public static <T> CommonRes<T> SUCCESS(T data, String totalRecord) {
        return new CommonRes<T>(200, "success", data, totalRecord);
    }

    public static <T> CommonRes<T> FAIL(ErrorCode codeEnum) {
        return new CommonRes<T>(codeEnum.code, codeEnum.message, null, null);
    }

    public static <T> CommonRes<T> FAIL(ErrorCode codeEnum, T data) {
        return new CommonRes<T>(codeEnum.code, codeEnum.message, data, null);
    }

    public static <T> CommonRes<T> FAIL(int code, String msg, T data) {
        return new CommonRes<T>(code, msg, data, null);
    }

    public static <T> CommonRes<T> FAIL(int code, String msg) {
        return new CommonRes<T>(code, msg, null, null);
    }

    public static <T> CommonRes<T> FAIL_WITH_CODE(int code, String msg) {
        if (null != msg && !"".equals(msg) && !msg.contains("(")) {
            msg += "(" + code + ")";
        }
        return new CommonRes<T>(code, msg, null, null);
    }

    public static <T> CommonRes<T> FAIL_WITH_CODE(ErrorCode codeEnum) {
       return FAIL_WITH_CODE(codeEnum.code,codeEnum.message);
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}