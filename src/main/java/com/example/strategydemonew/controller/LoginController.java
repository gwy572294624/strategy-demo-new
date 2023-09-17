package com.example.strategydemonew.controller;

import com.alibaba.fastjson.JSON;
import com.example.strategydemonew.common.LoginCommonStrategyRegistry;
import com.example.strategydemonew.common.LoginStrategy;
import com.example.strategydemonew.entity.LoginPatamDTO;
import com.example.strategydemonew.entity.LoginUserInfoVO;
import com.example.strategydemonew.entity.Result;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yueyue.guan
 * @date 2023/9/17 下午12:09
 * @description:
 */
@RestController
public class LoginController {
    /**
     * 模拟redis
     */
    public static Map<String, String> userInforedis = new ConcurrentHashMap<>();

    private final LoginCommonStrategyRegistry loginCommonStrategyRegistry;

    public LoginController(LoginCommonStrategyRegistry loginCommonStrategyRegistry) {
        this.loginCommonStrategyRegistry = loginCommonStrategyRegistry;
    }


    @RequestMapping(value = "/a/login")
    public Result<LoginUserInfoVO> login(LoginPatamDTO loginPatamDTO) {
        if (ObjectUtils.isEmpty(loginPatamDTO.getLoginTypeEnum())) {
            return Result.err("无效的登陆方式");
        }
        LoginStrategy loginStrategy = loginCommonStrategyRegistry.mapGet().get(
                loginPatamDTO.getLoginTypeEnum());
        if (loginStrategy == null) {
            return Result.err("无效的登陆方式");
        }
        Result result = loginStrategy.checkParam(loginPatamDTO);
        if (result.getCode() == 0) {
            return result;
        }
        Result<LoginUserInfoVO> login = loginStrategy.login(loginPatamDTO);
        if (login.getCode() == 1) {
            userInforedis.put(login.getDate().getToken(), JSON.toJSONString(login.getDate()));
        }
        return login;
    }

}
