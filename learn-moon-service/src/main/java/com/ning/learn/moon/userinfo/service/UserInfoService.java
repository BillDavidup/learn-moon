package com.ning.learn.moon.userinfo.service;

import com.ning.learn.moon.userinfo.bo.UserInfoBO;

/**
 * @Author: wudening
 * @Description:
 * @Date: 2021/4/26 5:26 下午
 */
public interface UserInfoService {
    UserInfoBO getUserMasterInfo(Long uid);
}
