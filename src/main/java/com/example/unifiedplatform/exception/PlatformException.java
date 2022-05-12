package com.example.unifiedplatform.exception;

public class PlatformException extends RuntimeException{
    private Integer code;

    public PlatformException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public PlatformException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
