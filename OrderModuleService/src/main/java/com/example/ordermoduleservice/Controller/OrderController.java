package com.example.ordermoduleservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @GetMapping(value = "/test")
    public String test(){
        String forObject = restTemplate.getForObject("http://user-server/user/test", String.class);
        System.out.println(forObject);
        return "调用orderController的test接口";
    }
}
