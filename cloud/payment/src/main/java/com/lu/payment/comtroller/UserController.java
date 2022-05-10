package com.lu.payment.comtroller;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.UserDto;
import com.lu.common.dto.UserInsertDto;
import com.lu.common.dto.UserPageGetDto;
import com.lu.common.dto.UserUpdateDto;
import com.lu.common.exception.ErrorCode;
import com.lu.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/4/23
 */
@RestController
public class UserController {

    @Autowired
    UserService payService;

    @Value("${server.port}")
    private String servicePort;


    @PostMapping(value = "user/insert")
    CommonRes insert(@RequestBody UserInsertDto userInsertDto){
        if (StringUtils.isEmpty(userInsertDto.getMobileNo()) || StringUtils.isEmpty(userInsertDto.getPassword())){
            return CommonRes.FAIL(ErrorCode.PARAMS_NOT_FULL);
        }
        Date date = new Date();
        long id = date.getTime();
        userInsertDto.setId(id);
        try {
            payService.insert(userInsertDto);
        } catch (Exception e) {
            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
        }
        return CommonRes.SUCCESS("新增成功");
    };

    @GetMapping(value = "user/delete")
    CommonRes delete(@RequestParam("id") Long id){
        try {
            payService.delete(id);
        } catch (Exception e) {
            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
        }
        return CommonRes.SUCCESS("删除成功");
    };

    @PostMapping(value = "user/update")
    CommonRes update(@RequestBody UserUpdateDto userUpdateDto){
        try {
            payService.update(userUpdateDto);
        } catch (Exception e) {
            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
        }
        return CommonRes.SUCCESS("更新成功");
    };

    @PostMapping(value = "user/pageGet")
    CommonRes<List<UserDto>> pageGet(@RequestBody UserPageGetDto userPageGetDto){
         List<UserDto> userDtos = payService.pageGet(userPageGetDto);
        if (CollectionUtils.isEmpty(userDtos)){
            return CommonRes.SUCCESS(null);
        }
        return CommonRes.SUCCESS(userDtos);
    };



}
