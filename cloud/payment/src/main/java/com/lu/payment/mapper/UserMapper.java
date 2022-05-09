package com.lu.payment.mapper;

import com.lu.common.dto.UserInsertDto;
import org.springframework.stereotype.Repository;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/4/23
 */
@Repository
public interface UserMapper {

     void insert(UserInsertDto userInsertDto);
}
