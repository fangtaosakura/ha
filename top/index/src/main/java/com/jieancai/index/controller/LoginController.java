package com.jieancai.index.controller;

import com.jieancai.commons.bean.login.UserAccount;
import com.jieancai.index.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : FangTao
 * @date : 15:53 2020-07-16
 * 登录
 */

@RequestMapping("/admin/index/login")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     */
    @PostMapping("/accountLogin")
    public Object accountLogin(@RequestBody UserAccount userAccount,
                               HttpServletResponse response) {
        return loginService.accountLogin(userAccount, response);
    }

}
