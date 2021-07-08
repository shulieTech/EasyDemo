package com.easydemo.usercenter.controller;

import com.easydemo.usercenter.converter.UserLoginInput2EntityConverter;
import com.easydemo.usercenter.converter.UserRegisterInput2EntityConverter;
import com.easydemo.usercenter.domain.entity.UserEntity;
import com.easydemo.usercenter.domain.input.UserLoginInput;
import com.easydemo.usercenter.domain.input.UserRegisterInput;
import com.easydemo.usercenter.exception.BizUserException;
import com.easydemo.usercenter.resp.RtnResp;
import com.easydemo.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public RtnResp registerUser(@RequestBody UserRegisterInput input) throws BizUserException {
        userService.registerUser(UserRegisterInput2EntityConverter.INSTANCE.input2Entity(input));
        return RtnResp.success("用户注册成功");
    }

    @RequestMapping("/login")
    public RtnResp userLogin(@RequestBody UserLoginInput input) throws BizUserException {
        UserEntity userEntity = userService.findUserByLogin(UserLoginInput2EntityConverter.INSTANCE.input2Entity(input));
        return RtnResp.success(userEntity);
    }

    @RequestMapping("/modify")
    public RtnResp modifyUser(@RequestBody UserRegisterInput input) throws BizUserException {
        userService.modifyUser(UserRegisterInput2EntityConverter.INSTANCE.input2Entity(input));
        return RtnResp.success("用户修改成功");
    }

    @RequestMapping("/delete")
    public RtnResp deleteUser(@RequestBody Integer userId) throws BizUserException {
        userService.deleteUser(userId);
        return RtnResp.success("用户删除成功");
    }

    @RequestMapping("/biz_data")
    public RtnResp countBizData() throws BizUserException {
        Integer bizTotal = userService.countBizData();
        return RtnResp.success("统计业务表数据: " + bizTotal);
    }

    @RequestMapping("/shadow_data")
    public RtnResp countShadowData() throws BizUserException {
        Integer shadowTotal = userService.countShadowData();
        return RtnResp.success("统计影子表数据: " + shadowTotal);
    }
}
