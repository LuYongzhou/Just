package com.lu.payment.service.impl;

import com.lu.common.dto.UserDto;
import com.lu.common.dto.UserInsertDto;
import com.lu.common.dto.UserPageGetDto;
import com.lu.common.dto.UserUpdateDto;
import com.lu.common.entity.UserEntity;
import com.lu.payment.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lu.payment.service.UserService;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/4/23
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(UserInsertDto userInsertDto) {
        userInsertDto.setDeleteStatus(0);
        log.info("UserServiceImpl-insert-入参：userInsertDto{}",userInsertDto);
        userMapper.insert(userInsertDto);
    }
    @Override
    public void delete(Long id) {
        log.info("UserServiceImpl-delete-入参：id{}",id);
        userMapper.delete(id);
    }
    @Override
    public void update(UserUpdateDto userUpdateDto) {
        log.info("UserServiceImpl-delete-入参：userUpdateDto{}",userUpdateDto);
        userMapper.update(userUpdateDto);
    }

    @Override
    public List<UserDto> pageGet(UserPageGetDto userPageGetDto) {
        userPageGetDto.setDeleteStatus(2);
        log.info("UserServiceImpl-delete-入参：userPageGetDto{}",userPageGetDto);
        List<UserEntity> userEntityList = userMapper.pageGet(userPageGetDto);
        log.info("UserServiceImpl-delete-出参：userEntityList{}",userEntityList);
        if (CollectionUtils.isEmpty(userEntityList)){
            return null;
        }
        List<UserDto> userDtos = new ArrayList<>();
        userEntityList.forEach(x ->{
            if (null != x){
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(x,userDto);
                userDtos.add(userDto);
            }
        });

        return userDtos;
    }
}
