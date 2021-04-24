package com.ning.learn.moon.lesson.dao;

import com.ning.learn.moon.lesson.model.UserLessonAi;
import com.ning.learn.moon.lesson.po.LessonInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserLessonAiDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserLessonAi record);

    int insertSelective(UserLessonAi record);

    UserLessonAi selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLessonAi record);

    int updateByPrimaryKey(UserLessonAi record);

    // 以下手写
    List<LessonInfoPO> listLessonInfo(@Param("studentId") Long uid, @Param("status") Integer status);
}