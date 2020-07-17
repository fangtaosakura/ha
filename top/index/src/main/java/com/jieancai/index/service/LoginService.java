package com.jieancai.index.service;

import com.jieancai.commons.bean.login.UserAccount;
import com.jieancai.commons.enums.PrefixEnum;
import com.jieancai.commons.utils.CommonResult;
import com.jieancai.commons.utils.UniqueKeyUtil;
import com.jieancai.index.dao.mapper.LoginMapper;
import com.jieancai.index.dao.response.LoginResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author : FangTao
 * @date : 15:55 2020-07-16
 */
@Slf4j
@Service
public class LoginService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 账号登录校验
     *
     * @param userAccount
     * @param response
     * @return
     */
    public Object accountLogin(UserAccount userAccount, HttpServletResponse response) {
        //查询账号是否存在，进行校检
        LoginResponse loginResponse = loginMapper.selectUser(userAccount);
        if (loginResponse==null){
            return new CommonResult().failed("暂无信息");
        }
        //进行密码对比
        if (!(loginResponse.getPassword().equals(DigestUtils.md5DigestAsHex(userAccount.getPassword().getBytes())))) {
            return new CommonResult().failed("密码错误");
        }
        //将用户uid存储到cookie
        String uuid = "COOKIE:"+ UniqueKeyUtil.genRandom(PrefixEnum.ACCOUNT.getCode());
        //存储redis
        redisTemplate.opsForValue().set(uuid, userAccount.getAccount(), 1, TimeUnit.HOURS);
        Map<String, Object> data = new HashMap<>();
        data.put("user", loginResponse);
        data.put("uuid", uuid);
        return new CommonResult().success(data);
    }
}
