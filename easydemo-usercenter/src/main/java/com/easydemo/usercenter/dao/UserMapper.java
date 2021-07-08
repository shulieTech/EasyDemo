package com.easydemo.usercenter.dao;

import com.easydemo.usercenter.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 新增用户
     */
    void insertUser(UserEntity user);

    /**
     * 查询用户：根据手机号
     */
    UserEntity queryUserByMobile(@Param(value = "mobile") String mobile);

    /**
     * 修改用户信息
     */
    int updateUser(UserEntity entity);

    /**
     * 新增用户
     */
    void deleteUser(Integer id);

    /**
     * 查询业务表数据量
     */
    Integer selectBizTotal();

    /**
     * 查询影子表数据量
     */
    Integer selectShadowTotal();

}
