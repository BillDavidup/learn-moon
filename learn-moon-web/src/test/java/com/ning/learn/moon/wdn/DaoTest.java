package com.ning.learn.moon.wdn;

import com.ning.learn.moon.TestBase;
import com.ning.learn.moon.lesson.dao.UserLessonAiDao;
import com.ning.learn.moon.lesson.model.UserLessonAi;
import com.ning.learn.moon.lesson.po.LessonInfoPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: wudening
 * @Description: mybatis dao层测试
 * @Date: 2021/4/24 6:03 下午
 */
public class DaoTest extends TestBase {

    @Autowired
    UserLessonAiDao userLessonAiDao;

    @Test
    public void testLessonAiDao() {
        UserLessonAi userLessonAi = userLessonAiDao.selectByPrimaryKey(1L);
        System.out.println("userLessonAi:" + userLessonAi);
        Long studentId = 1798395L;
        Integer status = 0;
        List<LessonInfoPO> lessonInfoList = userLessonAiDao.listLessonInfo(studentId, status);
        System.out.println("lessonInfoList:" + lessonInfoList);
    }
}
