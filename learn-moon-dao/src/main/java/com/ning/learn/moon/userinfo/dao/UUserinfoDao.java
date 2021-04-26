package com.ning.learn.moon.userinfo.dao;

import com.ning.learn.moon.userinfo.model.UUserinfo;
import com.ning.learn.moon.userinfo.po.UserInfoPO;
import org.apache.ibatis.annotations.Param;

public interface UUserinfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(UUserinfo record);

    int insertSelective(UUserinfo record);

    UUserinfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UUserinfo record);

    int updateByPrimaryKey(UUserinfo record);

    // 手写
    UserInfoPO selectStudentMasterInfo(@Param("uid") Long userId);
}