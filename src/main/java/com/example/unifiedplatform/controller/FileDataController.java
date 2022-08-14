package com.example.unifiedplatform.controller;

import com.example.unifiedplatform.VO.ResultVO;
import com.example.unifiedplatform.annotation.UserLoginToken;
import com.example.unifiedplatform.controller.form.FileDataForm;
import com.example.unifiedplatform.exception.PlatformException;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.service.FileDataService;
import com.example.unifiedplatform.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cloudSpace")
@Slf4j
@CrossOrigin(maxAge = 3600)
public class FileDataController {
    @Autowired
    FileDataService fileDataService;

    @PostMapping("/myCloudSpace")
    @UserLoginToken
    public ResultVO getMyCloudSpace(@RequestBody @Valid FileDataForm fileDataForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[云空间] 参数不正确， fileDataForm={}", fileDataForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        return ResultVOUtil.success(fileDataService.getMyCloudSpace(fileDataForm));
    }

    @PostMapping("/create")
    @UserLoginToken
    public ResultVO createFolder(@RequestBody @Valid FileDataForm fileDataForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[云空间] 参数不正确， fileDataForm={}", fileDataForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        return ResultVOUtil.success(fileDataService.createFolder(fileDataForm));
    }

    @PostMapping("/upload")
    @UserLoginToken
    public ResultVO saveFile(@RequestBody @Valid FileDataForm fileDataForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[云空间] 参数不正确， fileDataForm={}", fileDataForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        return ResultVOUtil.success(fileDataService.saveFile(fileDataForm));
    }

    @PostMapping("/delete")
    @UserLoginToken
    public ResultVO deleteFile(@RequestBody @Valid FileDataForm fileDataForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[云空间] 参数不正确， fileDataForm={}", fileDataForm);
            throw new PlatformException(ResultEnum.PARAM_ERROR);
        }
        fileDataService.deleteFile(fileDataForm);
        return ResultVOUtil.success("删除成功！");
    }
}
