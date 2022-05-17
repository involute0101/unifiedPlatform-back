package com.example.unifiedplatform.controller;

import com.example.unifiedplatform.VO.ResultVO;
import com.example.unifiedplatform.annotation.AdminAuthorize;
import com.example.unifiedplatform.annotation.UserLoginToken;
import com.example.unifiedplatform.exception.ResultEnum;
import com.example.unifiedplatform.utils.RandomUtil;
import com.example.unifiedplatform.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/util")
@Slf4j
@CrossOrigin(maxAge = 3600)
public class UtilController {

    @Value("${uploadPath}")
    private String uploadFilePath;

    @PostMapping("/upload")
    @UserLoginToken
    public ResultVO uploadFile(@RequestParam("file") MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        try{
            String fileRandomFix = RandomUtil.newCaptcha(6)+ "_" + new Date().getTime()/10000000 + "_"+originalFilename;
            File dest = new File(uploadFilePath + fileRandomFix);
            file.transferTo(dest);
            return ResultVOUtil.success("www.involute.cn:/files/"+fileRandomFix);
        } catch (IOException e) {
            return ResultVOUtil.error(ResultEnum.UPLOAD_FAILED);
        }
    }
}
