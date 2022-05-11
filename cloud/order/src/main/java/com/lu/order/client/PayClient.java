package com.lu.order.client;

import com.lu.common.constant.CommonRes;
import com.lu.common.dto.UserInsertDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "SERVER-PAYMENT")
public interface PayClient {

    @PostMapping(value = "user/insert")
    CommonRes insert(@RequestBody UserInsertDto carInsertDto);

}
