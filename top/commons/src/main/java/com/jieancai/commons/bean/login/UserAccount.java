package com.jieancai.commons.bean.login;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户信息实体类
 *
 * @author : FangTao
 * @date : 2020/7/16 14:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_account")
@Table(name = "t_user_account")
public class UserAccount implements Serializable {
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
