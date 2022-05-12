package com.example.unifiedplatform.controller;

import com.example.unifiedplatform.VO.ResultVO;
import com.example.unifiedplatform.annotation.PassToken;
import com.example.unifiedplatform.controller.form.LoginForm;
import com.example.unifiedplatform.exception.PlatformException;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.service.UserService;
import com.example.unifiedplatform.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(maxAge = 3600)
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @PassToken
    public ResultVO login(@Valid @RequestBody LoginForm loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[登录] 参数不正确， loginForm={}", loginForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        try{
            return ResultVOUtil.success(userService.login(loginForm));
        }catch (PlatformException e){
            return ResultVOUtil.error(500,e.getMessage());
        }

    }
}
