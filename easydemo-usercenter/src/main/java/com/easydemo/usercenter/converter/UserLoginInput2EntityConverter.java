package com.easydemo.usercenter.converter;

import com.easydemo.usercenter.domain.entity.UserEntity;
import com.easydemo.usercenter.domain.input.UserLoginInput;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @ClassName UserLoginInput2EntityConverter
 * @Description
 * @Author qianshui
 * @Date 2021/6/21 下午4:07
 */
@Mapper
public interface UserLoginInput2EntityConverter {
    UserLoginInput2EntityConverter INSTANCE = Mappers.getMapper(UserLoginInput2EntityConverter.class);

    UserEntity input2Entity(UserLoginInput source);

}
