package com.example.ordermoduleservice.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RefreshScope
public class NacosConfig {

    @Value("${pattern.dateformate}")
    private String dateformate;
}
