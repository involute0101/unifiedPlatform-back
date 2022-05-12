package com.example.unifiedplatform.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * http请求返回的最外层对象
 */
@Data
@ApiModel(value = "返回结果")
public class ResultVO<T> {

    @ApiModelProperty(value = "错误码")
    private Integer code;

    @ApiModelProperty(value = "提示信息")
    private String msg;

    @ApiModelProperty(value = "具体内容")
    private T data;
}
