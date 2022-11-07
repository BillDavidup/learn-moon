package com.ning.learn.moon.controller;

import com.ning.learn.moon.common.result.Result;
import com.ning.learn.moon.userinfo.bo.UserInfoBO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务验活接口
 */
@RestController
@RequestMapping("/api")
public class ServiceAliveController {

    @GetMapping("/alive")
    public Result<String> getUserMasterInfo() {
        return Result.createOK("Service learn-moon-web is alive", "验活成功");
    }

}
