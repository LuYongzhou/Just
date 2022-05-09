package com.lu.order.controller;

import com.alibaba.fastjson.JSON;
import com.lu.common.constant.CommonRes;
import com.lu.common.dto.CarInsertDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 卢泳州
 * @Description
 * @Date 2022/5/3
 */
@RestController
public class PayController {

    @Resource
    private RestTemplate restTemplate;

    private static String url = "http://server-payment";

    @PostMapping("car/insert")
    CommonRes carInsert(CarInsertDto carInsertDto){

        CommonRes commonRes = restTemplate.postForObject(url+"/car/insert",JSON.toJSONString(carInsertDto),CommonRes.class);
        return commonRes;
    }

}
