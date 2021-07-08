package com.easydemo.usercenter.converter;

import com.easydemo.usercenter.domain.entity.UserEntity;
import com.easydemo.usercenter.domain.input.UserRegisterInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName UserRegisterInput2EntityConverter
 * @Description
 * @Author qianshui
 * @Date 2021/6/21 下午4:07
 */
@Mapper
public interface UserRegisterInput2EntityConverter {
    UserRegisterInput2EntityConverter INSTANCE = Mappers.getMapper(UserRegisterInput2EntityConverter.class);

    UserEntity input2Entity(UserRegisterInput source);

}
