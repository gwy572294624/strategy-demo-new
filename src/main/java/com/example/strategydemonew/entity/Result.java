package com.example.strategydemonew.entity;

import lombok.Data;

/**
 * @author yueyue.guan
 * @date 2023/9/17 上午11:01
 * @description:
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T date;

    public Result() {
    }

    public Result(int code, String msg, T date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }


    public static Result suc() {
        return new Result(1, "成功", null);
    }

    public static Result suc(Object data) {
        return new Result(1, "成功", data);
    }


    public static Result err() {
        return new Result(0, "失败", null);
    }

    public static Result err(String msg) {
        return new Result(0, msg, null);
    }
}
