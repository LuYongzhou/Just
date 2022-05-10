package com.lu.payment.service;

import com.lu.common.dto.UserDto;
import com.lu.common.dto.UserInsertDto;
import com.lu.common.dto.UserPageGetDto;
import com.lu.common.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    void insert(UserInsertDto userInsertDto);

    void delete(Long id);

    void update(UserUpdateDto userUpdateDto);

    List<UserDto> pageGet(UserPageGetDto userPageGetDto);
}
