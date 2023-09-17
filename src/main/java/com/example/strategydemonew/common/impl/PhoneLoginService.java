package com.example.strategydemonew.common.impl;

import com.example.strategydemonew.common.AbstractLoginService;
import com.example.strategydemonew.common.LoginCommonStrategyRegistry;
import com.example.strategydemonew.entity.LoginPatamDTO;
import com.example.strategydemonew.entity.LoginUserInfoVO;
import com.example.strategydemonew.entity.Result;
import com.example.strategydemonew.enumpackage.LoginTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author yueyue.guan
 * @date 2023/9/17 上午11:59
 * @description:
 */
@Service
@Slf4j
public class PhoneLoginService extends AbstractLoginService {


    public PhoneLoginService(LoginCommonStrategyRegistry loginCommonStrategyRegistry) {
        super(loginCommonStrategyRegistry);
    }

    @Override
    protected void initRegistry() {
        super.loginCommonStrategyRegistry.registry(LoginTypeEnum.PHONE_TYPE, this.getClass());
    }

    @Override
    public Result checkParam(LoginPatamDTO loginPatamDTO) {
        if (ObjectUtils.isEmpty(loginPatamDTO.getPhone())) {
            return Result.err("手机号不能为空");
        }
        if (ObjectUtils.isEmpty(loginPatamDTO.getSmsCode())) {
            return Result.err("验证码不能为空");
        }
        return Result.suc();
    }

    @Override
    public Result<LoginUserInfoVO> login(LoginPatamDTO loginPatamDTO) {
        log.info("这里是手机号登陆");
        if (loginPatamDTO.getPhone().equals("17777777777") && loginPatamDTO.getSmsCode().equals("7777")) {
            // 创建默认对象 模拟登陆返回
            LoginUserInfoVO loginUserInfoVO = LoginUserInfoVO.loginUserInfoVOCreate(loginPatamDTO.getLoginTypeEnum());
            return Result.suc(loginUserInfoVO);
        } else {
            return Result.err("验证码不正确");
        }
    }
}
