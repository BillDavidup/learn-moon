package com.ning.learn.moon.userinfo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: wudening
 * @Description: 用户班主任信息BO
 * @Date: 2021/4/26 5:24 下午
 */
@Data
@ApiModel(value = "用户班主任信息")
public class UserInfoBO {
    @ApiModelProperty(value = "学生ID", name = "ID")
    Long id;
    @ApiModelProperty(value = "学生姓名", name = "姓名")
    String userName;
    @ApiModelProperty(value = "学生班主任", name = "班主任")
    Long master;
    @ApiModelProperty(value = "nacos统一配置中心读取的变量")
    String appVersionConfig;
}
