package com.itcodai.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.itcodai.springcloud.dao")
public class OrderProvider02 {

  public static void main(String[] args) {
    SpringApplication.run(OrderProvider02.class,args);
    System.out.println("OrderProvider02 启动成功");
  }

}
