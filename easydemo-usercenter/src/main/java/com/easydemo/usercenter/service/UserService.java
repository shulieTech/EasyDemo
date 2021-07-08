package com.easydemo.usercenter.service;

import com.easydemo.usercenter.domain.entity.UserEntity;
import com.easydemo.usercenter.exception.BizUserException;

public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    void registerUser(UserEntity user) throws BizUserException;

    UserEntity findUserByLogin(UserEntity entity) throws BizUserException;

    Boolean modifyUser(UserEntity entity) throws BizUserException ;

    void deleteUser(Integer id) throws BizUserException ;

    Integer countBizData() throws BizUserException ;

    Integer countShadowData() throws BizUserException ;

}