package com.easydemo.gateway.controller;

import com.alibaba.fastjson.JSON;
import com.easydemo.gateway.entity.UserParam;
import com.easydemo.gateway.resp.RtnResp;
import com.easydemo.gateway.util.HttpUtil;
import com.easydemo.gateway.util.ToolsUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
@RestController
@RequestMapping("/api")
public class GatewayController {

    @Value("${http.server.url}")
    private String userCenterUrl;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public RtnResp register(@RequestBody @Validated UserParam user) {
        if (!ToolsUtil.checkMobile(user.getMobile())) {
            return RtnResp.failure("注册失败: 手机号格式不正确【1开头，长度为11位】");
        }

        return HttpUtil.doHttpPost(JSON.toJSONString(user), userCenterUrl + "/user/add");
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping("/login")
    public RtnResp userLogin(@RequestBody @Validated UserParam user) {
        if (!ToolsUtil.checkMobile(user.getMobile())) {
            return RtnResp.failure("登录失败: 手机号格式不正确【1开头，长度为11位】");
        }

        return HttpUtil.doHttpPost(JSON.toJSONString(user), userCenterUrl + "/user/login");
    }

    /**
     * 用户修改
     *
     * @param user
     * @return
     */
    @PostMapping("/modify")
    public RtnResp modifyUser(@RequestBody @Validated UserParam user) {
        if (!ToolsUtil.checkMobile(user.getMobile())) {
            return RtnResp.failure("登录失败: 手机号格式不正确【1开头，长度为11位】");
        }

        return HttpUtil.doHttpPost(JSON.toJSONString(user), userCenterUrl + "/user/modify");
    }

    /**
     * 用户删除
     *
     * @param userId
     * @return
     */
    @PostMapping("/delete")
    public RtnResp deleteUser(@RequestBody @Validated Integer userId) {

        return HttpUtil.doHttpPost(JSON.toJSONString(userId), userCenterUrl + "/user/delete");
    }

}
