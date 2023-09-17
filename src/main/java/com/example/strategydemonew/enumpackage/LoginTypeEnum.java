package com.example.strategydemonew.enumpackage;

/**
 * @author yueyue.guan
 * @date 2023/9/16 上午11:43
 * @description:
 */
public enum LoginTypeEnum {

    USERNAME_TYPE("USERNAME","用户名登录"),
    PHONE_TYPE("PHONE","手机号登陆"),
    FINGERMARK_TYPE("FINGERMARK","指纹登录"),
    ;

    private String name;

    private String desc;

    LoginTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
