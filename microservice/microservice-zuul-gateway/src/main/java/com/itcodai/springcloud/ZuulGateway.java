package com.itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway {

  public static void main(String[] args) {
    SpringApplication.run(ZuulGateway.class, args);
    System.out.println("ZuulGateway 启动成功");
  }
}
