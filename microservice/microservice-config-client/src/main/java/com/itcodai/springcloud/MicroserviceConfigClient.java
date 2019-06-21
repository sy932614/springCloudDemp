package com.itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
public class MicroserviceConfigClient {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceConfigClient.class, args);
    System.out.println("MicroserviceConfigClient 启动成功");
  }
}
