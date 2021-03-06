package com.lu.payment.comtroller;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.CarInsertDto;
import com.lu.common.dto.UserDto;
import com.lu.common.dto.UserInsertDto;
import com.lu.common.dto.UserPageGetDto;
import com.lu.common.dto.UserUpdateDto;
import com.lu.common.exception.ErrorCode;
import com.lu.payment.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户")
public class UserController{

    @Autowired
    private UserService payService;

    @ApiOperation("新增用户信息")
    @PostMapping(value = "user/insert")
    public CommonRes insert(@RequestBody UserInsertDto userInsertDto){
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

//    @GetMapping(value = "user/delete")
//    @ApiOperation("删除用户信息")
//    CommonRes delete(@RequestParam("id") Long id){
//        try {
//            payService.delete(id);
//        } catch (Exception e) {
//            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
//        }
//        return CommonRes.SUCCESS("删除成功");
//    };
//
//    @PostMapping(value = "user/update")
//    @ApiOperation("更新用户信息")
//    CommonRes update(@RequestBody UserUpdateDto userUpdateDto){
//        try {
//            payService.update(userUpdateDto);
//        } catch (Exception e) {
//            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
//        }
//        return CommonRes.SUCCESS("更新成功");
//    };
//
//    @PostMapping(value = "user/pageGet")
//    @ApiOperation("查询用户信息")
//    CommonRes<List<UserDto>> pageGet(@RequestBody UserPageGetDto userPageGetDto){
//         List<UserDto> userDtos = payService.pageGet(userPageGetDto);
//        if (CollectionUtils.isEmpty(userDtos)){
//            return CommonRes.SUCCESS(null);
//        }
//        return CommonRes.SUCCESS(userDtos);
//    };



}
