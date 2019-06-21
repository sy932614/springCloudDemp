package com.itcodai.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.itcodai.springcloud.dao")
@EnableCircuitBreaker
public class OrderProvider01 {

  public static void main(String[] args) {
    SpringApplication.run(OrderProvider01.class,args);
    System.out.println("OrderProvider01 启动成功");
  }

}
