package com.easydemo.usercenter.domain.input;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserLoginInput
 * @Description
 * @Author qianshui
 * @Date 2021/6/21 下午4:32
 */
@Data
public class UserLoginInput implements Serializable {

    private String mobile;

    private String password;
}
