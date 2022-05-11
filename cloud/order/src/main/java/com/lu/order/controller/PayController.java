package com.lu.order.controller;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.UserInsertDto;
import com.lu.order.client.PayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/3
 */


@RestController
public class PayController {

    @Autowired
    private PayClient payClient;

    @PostMapping(value = "user/insert")
    CommonRes insert(@RequestBody UserInsertDto carInsertDto){
        payClient.insert(carInsertDto);
        return CommonRes.SUCCESS(null);
    };

}
