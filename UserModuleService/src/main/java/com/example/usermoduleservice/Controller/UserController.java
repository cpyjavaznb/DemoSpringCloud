package com.example.usermoduleservice.Controller;

//import com.example.usermoduleservice.feign.FeignOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @GetMapping(value = "/test")
    public String test(){
        System.out.println("调用userController");
        return "调用userController";
    }

}
