package com.example.unifiedplatform.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "云空间文件-表单")
public class FileDataForm {

    @ApiModelProperty(value = "用户账号",required = true)
    @NotEmpty(message = "用户账号 不能为空")
    private String account;

    private Integer page;

    private Integer size;

    @ApiModelProperty(value = "父文件夹路径",required = true)
    private String parentPath;

    private String folderName;

    private Integer id;
}
