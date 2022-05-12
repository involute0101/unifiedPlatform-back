package com.example.unifiedplatform.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "分页请求-表单")
public class PageForm {

    @ApiModelProperty(value = "页数",required = true)
    private Integer page;

    @ApiModelProperty(value = "页大小",required = true)
    private Integer size;
}
