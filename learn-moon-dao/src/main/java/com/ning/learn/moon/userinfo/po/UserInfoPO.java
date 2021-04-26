package com.ning.learn.moon.userinfo.po;

import lombok.Data;

/**
 * @Author: wudening
 * @Description: 用户信息PO
 * @Date: 2021/4/26 5:07 下午
 */
@Data
public class UserInfoPO {
    // 学生ID
    private Long id;
    // 学生姓名
    private String userName;
    // 班主任ID
    private Long  master;
}
