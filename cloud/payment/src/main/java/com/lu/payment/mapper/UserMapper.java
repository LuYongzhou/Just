package com.lu.payment.mapper;

import com.lu.common.dto.UserInsertDto;
import com.lu.common.dto.UserPageGetDto;
import com.lu.common.dto.UserUpdateDto;
import com.lu.common.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/4/23
 */
@Repository
public interface UserMapper {

     void insert(UserInsertDto userInsertDto);

    void delete(Long id);

    void update(UserUpdateDto userUpdateDto);

    List<UserEntity> pageGet(UserPageGetDto userPageGetDto);
}
