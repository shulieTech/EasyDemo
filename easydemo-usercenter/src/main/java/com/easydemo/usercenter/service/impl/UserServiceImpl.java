package com.easydemo.usercenter.service.impl;

import com.easydemo.usercenter.dao.UserMapper;
import com.easydemo.usercenter.domain.entity.UserEntity;
import com.easydemo.usercenter.exception.BizUserException;
import com.easydemo.usercenter.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author qianshui
 * @Date 2021/6/21 下午3:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void registerUser(UserEntity user) throws BizUserException {
//        if (userMapper.queryUserByMobile(user.getMobile()) != null) {
//            throw new BizUserException("手机号已注册:" + user.getMobile());
//        }
        try {
            userMapper.insertUser(user);
        } catch (Exception e) {
            throw new BizUserException("用户注册，写入数据库失败:");
        }
    }

    @Override
    public UserEntity findUserByLogin(UserEntity entity) throws BizUserException {

        UserEntity user = userMapper.queryUserByMobile(entity.getMobile());
        if (user == null) {
            throw new BizUserException("登录失败:手机号输入错误");
        }
        if (!user.getPassword().equals(entity.getPassword())) {
            throw new BizUserException("登录失败:密码输入错误");
        }
        return user;
    }

    @Override
    public Boolean modifyUser(UserEntity entity) throws BizUserException {
        boolean isTrue = Boolean.TRUE;
        try {
            int count = userMapper.updateUser(entity);
            if (count != 1) {
                isTrue = Boolean.FALSE;
            }
        } catch (Exception e) {
            throw new BizUserException("修改用户信息，数据库操作失败");
        }
        return isTrue;

    }

    @Override
    public void deleteUser(Integer id) throws BizUserException {
        try {
            userMapper.deleteUser(id);
        } catch (Exception e) {
            throw new BizUserException("用户删除，数据库操作失败");
        }
    }

    @Override
    public Integer countBizData() throws BizUserException {
        Integer total = 0;
        try {
            total = userMapper.selectBizTotal();
        } catch (Exception e) {
            throw new BizUserException("查询业务表数据库异常");
        }

        return total;
    }

    @Override
    public Integer countShadowData() throws BizUserException {
        Integer total = 0;
        try {
            total = userMapper.selectShadowTotal();
        } catch (Exception e) {
            throw new BizUserException("查询影子表数据库异常");
        }

        return total;
    }

}
