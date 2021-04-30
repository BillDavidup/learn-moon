package com.ning.learn.moon.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.ning.learn.moon.common.result.Result;
import com.ning.learn.moon.userinfo.bo.UserInfoBO;
import com.ning.learn.moon.userinfo.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @Author: wudening
 * @Description: 用户信息Api控制器
 * @Date: 2021/4/26 5:40 下午
 */
@Slf4j
@Api(tags = "UserInfoController")
@ApiSort(1) // Knife4j API文档 Controller排序
@RestController
@RequestMapping("/api")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperationSupport(order = 1) // Knife4j API文档接口级别排序
    @ApiOperation(value = "获取学生信息接口", nickname = "根据学生ID获取用学生相关信息") // Knife4j API文档接口信息
    @ApiImplicitParam(name = "studentId", value = "学生ID", required = true, dataType = "Long", dataTypeClass = Long.class) // Knife4j API文档参数定义
    @GetMapping("/user/master/info")
    public Result<UserInfoBO> getUserMasterInfo(@RequestParam("studentId") Long uid) {
        log.info("获取学生信息接口,uid:{}", uid);
        UserInfoBO userMasterInfo = userInfoService.getUserMasterInfo(uid);
        return Result.createOK(userMasterInfo, "接入配置中心nacos获取的版本号成功");
    }

    @ApiOperationSupport(order = 2) // Knife4j API文档接口级别排序
    @ApiOperation(value = "获取学生信息接口V2", nickname = "根据学生ID获取用学生相关信息V2") // Knife4j API文档接口信息
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学生ID", required = true, dataType = "Long", dataTypeClass = Long.class),
            @ApiImplicitParam(name = "master", value = "学生班主任ID", required = false, dataType = "Long", dataTypeClass = Long.class)
    })
    @GetMapping("/user/master/info/v2")
    public Result<UserInfoBO> getUserMasterInfo2(@RequestParam("studentId") Long uid, @RequestParam(name = "master", required = false) Long master) {
        UserInfoBO userMasterInfo = userInfoService.getUserMasterInfo(uid);
        if (Objects.nonNull(master) && master.equals(123L)) {
            return Result.createOK(userMasterInfo);
        } else {
            return Result.createFail("班主任不能为空");
        }
    }
}
