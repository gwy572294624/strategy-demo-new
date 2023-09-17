package com.example.strategydemonew.entity;

import com.example.strategydemonew.enumpackage.LoginTypeEnum;
import lombok.Data;

/**
 * @author yueyue.guan
 * @date 2023/9/16 上午11:48
 * @description:
 */
@Data
public class UserInfoBO {

    private String userId;

    private String userRealName;

    private String userSex;

    private String userDeptIds;

    private LoginTypeEnum loginTypeEnum;

    public static UserInfoBO userInfoBOGet(LoginTypeEnum loginTypeEnum) {
        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setUserId("这个是id");
        userInfoBO.setUserRealName("这个是名字");
        userInfoBO.setUserSex("这个是性别");
        userInfoBO.setUserDeptIds("这个是部门");
        userInfoBO.setLoginTypeEnum(loginTypeEnum);
        return userInfoBO;
    }
}
