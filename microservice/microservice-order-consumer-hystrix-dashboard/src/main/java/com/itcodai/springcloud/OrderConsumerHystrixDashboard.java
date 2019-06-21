package com.itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class OrderConsumerHystrixDashboard {

  public static void main(String[] args) {
    SpringApplication.run(OrderConsumerHystrixDashboard.class, args);
    System.out.println("OrderConsumerHystrixDashboard 启动成功");
  }
}
