package com.itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfig {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceConfig.class, args);
    System.out.println("MicroserviceConfig 启动成功");
  }
}
