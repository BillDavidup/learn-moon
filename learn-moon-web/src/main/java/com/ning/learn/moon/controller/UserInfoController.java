package com.ning.learn.moon.controller;

import com.ning.learn.moon.userinfo.bo.UserInfoBO;
import com.ning.learn.moon.userinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wudening
 * @Description: 用户信息Api控制器
 * @Date: 2021/4/26 5:40 下午
 */
@RestController
@RequestMapping("/api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user/master/info")
    public Object getUserMasterInfo(@RequestParam("studentId") Long uid) {
        UserInfoBO userMasterInfo = userInfoService.getUserMasterInfo(uid);
        return userMasterInfo;
    }

}
