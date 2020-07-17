package com.jieancai.index.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jieancai.commons.bean.login.UserAccount;
import com.jieancai.index.dao.response.LoginResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : FangTao
 * @date : 16:51 2020-07-16
 */
@Mapper
public interface LoginMapper extends BaseMapper<UserAccount> {
    //查询用户
    LoginResponse selectUser(@Param("userAccount") UserAccount userAccount);
}
