package com.itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer02 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServer02.class, args);
    System.out.println("EurekaServer02 启动成功");
  }
}
