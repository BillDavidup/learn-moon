package com.ning.learn.moon.userinfo.service.impl;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ning.learn.moon.userinfo.bo.UserInfoBO;
import com.ning.learn.moon.userinfo.dao.UUserinfoDao;
import com.ning.learn.moon.userinfo.po.UserInfoPO;
import com.ning.learn.moon.userinfo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wudening
 * @Description: 用户信息服务实现类
 * @Date: 2021/4/26 5:21 下午
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UUserinfoDao uUserinfoDao;

    @NacosValue(value = "${learn-moon.app.version:2.8.0}", autoRefreshed = true)
    private String appVersion;

    @Override
    public UserInfoBO getUserMasterInfo(Long uid) {
        log.info("获取学生信息接口service,uid:{}", uid);
        UserInfoPO userMasterInfo = uUserinfoDao.selectStudentMasterInfo(uid);
        Long id = userMasterInfo.getId();
        String userName = userMasterInfo.getUserName();
        Long master = userMasterInfo.getMaster();

        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setId(id);
        userInfoBO.setUserName(userName);
        userInfoBO.setMaster(master);
        userInfoBO.setAppVersionConfig(appVersion);

        return userInfoBO;
    }
}
