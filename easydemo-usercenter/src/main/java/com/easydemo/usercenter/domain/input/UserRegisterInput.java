package com.easydemo.usercenter.domain.input;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserInput
 * @Description
 * @Author qianshui
 * @Date 2021/6/21 下午3:59
 */
@Data
public class UserRegisterInput implements Serializable {

    private String mobile;

    private String password;

    private String nickName;

    private String email;

    private String birthDay;

    private String provinceName;

    private String cityName;

}
