package com.jieancai.index.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : FangTao
 * @date : 16:56 2020-07-16
 * 查询用户返回实体类
 */

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse implements Serializable {
    //人员唯一键，用于判断重复和更新
    private String userId;

    //登录帐号
    private String account;

    //登录密码
    private String password;

    //状态
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
