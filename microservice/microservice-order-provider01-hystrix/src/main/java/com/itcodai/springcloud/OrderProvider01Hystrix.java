package com.itcodai.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan("com.itcodai.springcloud.dao")
public class OrderProvider01Hystrix {

  public static void main(String[] args) {
    SpringApplication.run(OrderProvider01Hystrix.class,args);
    System.out.println("OrderProvider01Hystrix 启动成功");
  }

}
