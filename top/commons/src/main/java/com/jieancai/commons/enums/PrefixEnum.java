package com.jieancai.commons.enums;

/**
 * 标识前缀
 */
public enum PrefixEnum {
    //账户编号
    ACCOUNT("ACCOUNT", "账户前缀");

    private String code;
    private String msg;


    PrefixEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
