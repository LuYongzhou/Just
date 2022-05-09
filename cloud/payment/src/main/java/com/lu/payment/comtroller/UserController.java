package com.lu.payment.comtroller;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.UserInsertDto;
import com.lu.common.exception.ErrorCode;
import com.lu.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "user/insert")
    CommonRes insert(@RequestBody UserInsertDto userInsertDto){
        Date date = new Date();
        long id = date.getTime();
        userInsertDto.setId(id);
//        try {
            payService.insert(userInsertDto);
//        } catch (Exception e) {
//            return CommonRes.FAIL(ErrorCode.SQL_EXCEPTION);
//        }
        return CommonRes.SUCCESS(servicePort+"新增成功");
    };

    @PostMapping(value = "car/getInstance")
    CommonRes getInstance(){

        ArrayList<List> objects = new ArrayList<List>();
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVER-PAYMENT");
        objects.add(services);
        objects.add(instances);
        return CommonRes.SUCCESS(objects);

    };

}
