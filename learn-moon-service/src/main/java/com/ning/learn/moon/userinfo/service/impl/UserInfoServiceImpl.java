package com.ning.learn.moon.userinfo.service.impl;

import com.ning.learn.moon.userinfo.bo.UserInfoBO;
import com.ning.learn.moon.userinfo.dao.UUserinfoDao;
import com.ning.learn.moon.userinfo.po.UserInfoPO;
import com.ning.learn.moon.userinfo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wudening
 * @Description: 用户信息服务实现类
 * @Date: 2021/4/26 5:21 下午
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UUserinfoDao uUserinfoDao;

    @Override
    public UserInfoBO getUserMasterInfo(Long uid) {
        UserInfoPO userMasterInfo = uUserinfoDao.selectStudentMasterInfo(uid);
        Long id = userMasterInfo.getId();
        String userName = userMasterInfo.getUserName();
        Long master = userMasterInfo.getMaster();

        UserInfoBO userInfoBO = new UserInfoBO();
        userInfoBO.setId(id);
        userInfoBO.setUserName(userName);
        userInfoBO.setMaster(master);

        return userInfoBO;
    }
}
