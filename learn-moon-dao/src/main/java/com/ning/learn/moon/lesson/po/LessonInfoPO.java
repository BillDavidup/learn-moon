package com.ning.learn.moon.lesson.po;

import lombok.Data;

/**
 * @Author: wudening
 * @Description: AI课程信息编号PO
 * @Date: 2021/4/24 6:15 下午
 */
@Data
public class LessonInfoPO {
    // 主键ID
    Long id;
    // 课程编号
    Long courseId;
    // 学生ID
    Long studentId;
    // 课程编号
    String courseNo;
    // 课程状态
    Integer status;
}
