package com.example.unifiedplatform.controller;

import com.example.unifiedplatform.VO.ResultVO;
import com.example.unifiedplatform.annotation.AdminAuthorize;
import com.example.unifiedplatform.annotation.UserLoginToken;
import com.example.unifiedplatform.controller.form.PageForm;
import com.example.unifiedplatform.controller.form.TaskForm;
import com.example.unifiedplatform.exception.PlatformException;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.service.TaskService;
import com.example.unifiedplatform.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/task")
@Slf4j
@CrossOrigin(maxAge = 3600)
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/list")
    @UserLoginToken
    public ResultVO list(@RequestBody @Valid PageForm pageForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[分页] 参数不正确， pageForm={}", pageForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = PageRequest.of(pageForm.getPage()-1, pageForm.getSize());
        System.out.println(pageRequest.getPageNumber()+":"+ pageRequest.getPageSize());
        return ResultVOUtil.success(taskService.getTask(pageRequest));
    }

    @PostMapping("/publish")
    @UserLoginToken
    @AdminAuthorize
    public ResultVO publish(@RequestBody @Valid TaskForm taskForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[发布] 参数不正确， taskForm={}", taskForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        boolean result = taskService.publishTask(taskForm);
        return ResultVOUtil.success(result);
    }
}
