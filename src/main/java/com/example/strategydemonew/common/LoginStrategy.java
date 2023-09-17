package com.example.strategydemonew.common;

import com.example.strategydemonew.entity.LoginPatamDTO;
import com.example.strategydemonew.entity.LoginUserInfoVO;
import com.example.strategydemonew.entity.Result;

/**
 * @author yueyue.guan
 * @date 2023/9/16 上午11:45
 * @description:
 */
public interface LoginStrategy {

    /**
     * 检查参数
     * @return
     */
    default Result checkParam(LoginPatamDTO loginPatamDTO){
        return Result.err();
    }

    /**
     * 登陆
     * @param loginPatamDTO
     * @return
     */
    default Result<LoginUserInfoVO> login(LoginPatamDTO loginPatamDTO){
        return Result.err();
    }
}
