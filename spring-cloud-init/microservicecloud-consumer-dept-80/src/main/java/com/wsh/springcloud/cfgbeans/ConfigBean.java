package com.wsh.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jue
 * @date 2019/3/25 23:49
 * @describe
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
