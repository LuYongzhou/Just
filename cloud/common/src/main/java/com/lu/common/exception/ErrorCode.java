package com.lu.common.exception;

/**
 * 通用错误码，范围900001~999999
 */
public enum ErrorCode {

    PARAMS_NOT_FULL(900001,"参数传输不全"),
    TASK_IS_WORKING(900002,"任务还在进行"),
    SYSTEM_BUSY(900003,"请求失败，请稍后重试"),
    REQUEST_TIMEOUT(900004,"请求超时，请稍后再试"),
    PARAMS_BIND_EXCEPTION(900005,"参数绑定错误"),
    HTTP_REQUEST_EXCEPTION(900006,"http请求出错"),
    DECRYPT_EXCEPTION(900007,"参数加解密异常"),
    NULL_POINT_EXCEPTION(900008,"空指针异常"),
    CLIENT_EXCEPTION(900009,"服务发现异常"),
    IO_ERROR_CODE(900010, "IO错误"),
    SQL_EXCEPTION(900011,"数据库操作异常"),
    JSON_FORMAT_EXCEPTION(900012, "JSON反序列失败异常"),
    LOGIN_VALIDATE_FAIL(900013,"登录失效,请重新登录"),
    LOGIN_TOKEN_INVALID(900014, "令牌失效"),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(900015, "http消息读取失败异常"),
    USER_INFO_GET_FAILED(900016, "获取用户信息失败"),
    SYSTEM_ERROR(999999, "系统错误");

    public final int code;
    public final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}