package com.example.unifiedplatform.controller.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "发布任务-表单")
public class TaskForm {

    private String title;

    private String content;

    private String files;

    private String deadline;
}
