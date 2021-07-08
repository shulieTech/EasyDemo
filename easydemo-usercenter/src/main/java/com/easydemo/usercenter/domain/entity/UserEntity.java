package com.easydemo.usercenter.domain.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -1369148652554782331L;

    private Long id;

    private String mobile;

    private String password;

    private String nickName;

    private String email;

    private String birthDay;

    private String provinceName;

    private String cityName;
}
