package com.itcodai.springcloud;

import com.itcodai.springcloud.config.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICE-ORDER",configuration = MyRuleConfig.class)
public class OrderConsumer {

  public static void main(String[] args) {
    SpringApplication.run(OrderConsumer.class,args);
    System.out.println("OrderConsumer 启动成功"+8%5);
  }

}
