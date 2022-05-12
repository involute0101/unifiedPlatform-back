package com.example.unifiedplatform.utils;

import com.example.unifiedplatform.VO.ResultVO;
import com.example.unifiedplatform.exception.ResultEnum;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(ResultEnum paramError) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(paramError.getCode());
        resultVO.setMsg(paramError.getMessage());
        return resultVO;
    }
}