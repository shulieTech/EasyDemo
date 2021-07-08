package com.easydemo.gateway.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
@Data
public class UserParam implements Serializable {

    private static final long serialVersionUID = -1369148652554782331L;

    @NotEmpty(message = "手机号不能为空")
    private String mobile;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String nickName;

    private String email;

    private String birthDay;

    private String provinceName;

    private String cityName;

}
