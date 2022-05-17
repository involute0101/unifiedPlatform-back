package com.example.unifiedplatform.exception;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),
    TOKEN_FAIL(1,"无token，请重新登录"),
    USER_NOT_EXIST(2,"用户不存在，请重新登录"),
    PARAM_ERROR(3,"参数错误"),
    PWD_ERROR(4,"密码错误"),
    PERMISSION_FORBIDDEN(5,"权限不足"),
    UPLOAD_FAILED(6,"上传失败");

    private Integer code;

    private String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
