package com.example.strategydemonew.entity;

import com.example.strategydemonew.enumpackage.LoginTypeEnum;
import lombok.Data;

/**
 * @author yueyue.guan
 * @date 2023/9/17 上午11:11
 * @description:
 */
@Data
public class LoginPatamDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 指纹
     */
    private String fingermark;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 短信验证码
     */
    private String smsCode;

    /**
     * 登陆方式
     */
    private LoginTypeEnum loginTypeEnum;
}
