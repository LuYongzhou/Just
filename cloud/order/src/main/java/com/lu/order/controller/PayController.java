package com.lu.order.controller;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.UserInsertDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/3
 */

@FeignClient(value = "SERVER-PAYMENT")
@Component
public interface PayController {

    @PostMapping(value = "user/insert")
    CommonRes insert(@RequestBody UserInsertDto carInsertDto);

}
