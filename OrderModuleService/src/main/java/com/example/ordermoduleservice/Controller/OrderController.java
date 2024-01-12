package com.example.ordermoduleservice.Controller;

import com.example.ordermoduleservice.Config.NacosConfig;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private NacosConfig nacosConfig;
    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/test")
    public String test(){
        String forObject = restTemplate.getForObject("http://user-server/user/test", String.class);
        System.out.println(forObject);
        return "调用orderController的test接口";
    }

    @GetMapping(value = "/time")
    public String getTime(){
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(nacosConfig.getDateformate())));
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(nacosConfig.getDateformate()));
    }

}
