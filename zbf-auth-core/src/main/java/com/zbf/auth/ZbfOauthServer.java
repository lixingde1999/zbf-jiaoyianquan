package com.zbf.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: LCG
 * 作者: LCG
 * 日期: 2020/9/6  14:11
 * 描述:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZbfOauthServer {
    public static void main(String[] args) {
        SpringApplication.run(ZbfOauthServer.class);
    }
}
