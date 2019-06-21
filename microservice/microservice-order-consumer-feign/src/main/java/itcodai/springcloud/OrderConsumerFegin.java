package itcodai.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Administrator on 2019/6/12.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderConsumerFegin {

  public static void main(String[] args) {
    SpringApplication.run(OrderConsumerFegin.class,args);
    System.out.println("OrderConsumerFegin 启动成功");
  }

}
