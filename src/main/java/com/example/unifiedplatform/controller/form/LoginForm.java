package com.example.unifiedplatform.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "登录-表单")
public class LoginForm {
    @ApiModelProperty(value = "邮箱/手机号",required = true)
    @NotEmpty(message = "邮箱/手机号 不能为空")
    private String account;

    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty(message =  "密码不能为空")
    private String password;
}
