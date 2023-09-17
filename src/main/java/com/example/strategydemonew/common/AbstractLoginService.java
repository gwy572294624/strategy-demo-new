package com.example.strategydemonew.common;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yueyue.guan
 * @date 2023/9/17 上午11:15
 * @description:
 */
@Service
public abstract class AbstractLoginService implements LoginStrategy {

    protected final LoginCommonStrategyRegistry loginCommonStrategyRegistry;
    public AbstractLoginService(LoginCommonStrategyRegistry loginCommonStrategyRegistry){
        this.loginCommonStrategyRegistry = loginCommonStrategyRegistry;
    }

    /**
     * 注册当前类到策略map中
     */
    @PostConstruct
    protected abstract void initRegistry();

}
