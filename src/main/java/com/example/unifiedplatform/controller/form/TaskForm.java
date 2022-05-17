package com.example.unifiedplatform.controller.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@ApiModel(value = "发布任务-表单")
public class TaskForm {

    @ApiModelProperty(value = "任务标题",required = true)
    @NotEmpty(message = "任务标题 不能为空")
    private String title;

    @ApiModelProperty(value = "任务描述",required = true)
    @NotEmpty(message = "任务描述 不能为空")
    private String content;

    @ApiModelProperty(value = "文件",required = false)
    private String files;

    @ApiModelProperty(value = "截止日期",required = true)
    @NotEmpty(message = "截止日期 不能为空")
    private String deadline;
}
