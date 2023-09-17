package com.example.strategydemonew.entity;

import com.example.strategydemonew.enumpackage.LoginTypeEnum;
import lombok.Data;

import java.util.UUID;

/**
 * @author yueyue.guan
 * @date 2023/9/16 上午11:46
 * @description:
 */
@Data
public class LoginUserInfoVO {

    private String token;

    private UserInfoBO userInfoBO;

    public static LoginUserInfoVO loginUserInfoVOCreate(LoginTypeEnum loginTypeEnum){
        UserInfoBO userInfoBO = UserInfoBO.userInfoBOGet(loginTypeEnum);
        LoginUserInfoVO loginUserInfoVO = new LoginUserInfoVO();
        loginUserInfoVO.setToken(UUID.randomUUID().toString());
        loginUserInfoVO.setUserInfoBO(userInfoBO);
        return loginUserInfoVO;
    }
}
