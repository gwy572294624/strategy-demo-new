package com.example.strategydemonew.common;

import com.example.strategydemonew.enumpackage.LoginTypeEnum;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yueyue.guan
 * @date 2023/9/17 上午11:16
 * @description:
 */
@Component
public class LoginCommonStrategyRegistry {

    @Autowired
    private BeanFactory beanFactory;


    private Map<LoginTypeEnum, LoginStrategy> loginrCommonStrategyMap = new ConcurrentHashMap<>();

    public Map<LoginTypeEnum, LoginStrategy> mapGet() {
        return this.loginrCommonStrategyMap;
    }

    /**
     * 初始化策略
     */
    public void registry(LoginTypeEnum loginTypeEnum, Class glass) {
        LoginStrategy funderCommonStrategy = (LoginStrategy)beanFactory.getBean(glass);
        this.loginrCommonStrategyMap.put(loginTypeEnum, funderCommonStrategy);
    }
}
