package com.example.usermoduleservice.Controller;

//import com.example.usermoduleservice.feign.FeignOrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${pattern.dateformate}")
    private String dateformate;
    @GetMapping(value = "/test")
    public String test(@RequestHeader(value = "Truth",required = false) String truth){
        System.out.println("调用userController");
        System.out.println(truth);
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(dateformate)));
        return "调用userController";
    }

}
