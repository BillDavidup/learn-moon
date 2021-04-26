package com.ning.learn.moon.userinfo.bo;

import lombok.Data;

/**
 * @Author: wudening
 * @Description: 用户班主任信息BO
 * @Date: 2021/4/26 5:24 下午
 */
@Data
public class UserInfoBO {
    Long id;
    String userName;
    Long master;
}
