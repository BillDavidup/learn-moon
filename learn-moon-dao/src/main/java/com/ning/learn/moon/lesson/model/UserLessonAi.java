package com.ning.learn.moon.lesson.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user_lesson_ai
 * @author 
 */
@Data
public class UserLessonAi implements Serializable {
    /**
     * 上课记录自增主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * T顶层体系编号
     */
    private String tNo;

    /**
     * G体系编号
     */
    private String gNo;

    /**
     * U单元体系编号
     */
    private String uNo;

    /**
     * 课件主键ID
     */
    private Long courseId;

    /**
     * 课程编号
     */
    private String courseNo;

    /**
     * 本节课扣除的课时,小数点保留2位
     */
    private Double deductHours;

    /**
     * 课程类型,1:优享AI课
     */
    private Integer courseType;

    /**
     * AI课状态 0=>'已创建-用户下单优享成功后，根据课程体系创建', 1=>'待上课', 2=>'进行中', 3=>'已到课
     */
    private Integer status;

    /**
     * 课程兑换时间(AI课兑换时间),单位:秒
     */
    private Integer redeemTime;

    /**
     * 学生上课时间,单位:秒
     */
    private Integer attendTime;

    /**
     * 创建时间,单位:秒
     */
    private Integer ctime;

    /**
     * 更新时间,单位:秒
     */
    private Integer utime;

    /**
     * 本节课学生累加上课时长,单位:秒
     */
    private Integer attendDuration;

    /**
     * 学生对课程点评内容
     */
    private String comment;

    /**
     * 创建记录的管理员ID
     */
    private Integer cid;

    /**
     * 修改记录的管理员ID
     */
    private Integer mid;

    /**
     * 是否删除, 0:未删除 1:已删除
     */
    private Integer del;

    /**
     * 备注
     */
    private String note;

    /**
     * 科目id
     */
    private Long subjectId;

    /**
     * 学习完课程时间,单位:秒
     */
    private Integer completeTime;

    /**
     * 优享订单ID
     */
    private Integer buyId;

    private static final long serialVersionUID = 1L;
}