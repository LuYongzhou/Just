package com.lu.payment.service.impl;

import com.lu.common.dto.UserInsertDto;
import com.lu.payment.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lu.payment.service.UserService;

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

    public void insert(UserInsertDto userInsertDto) {
        log.info("UserServiceImpl-insert-入参：userInsertDto{}",userInsertDto);
        userMapper.insert(userInsertDto);
    }
}
