package com.itcodai.springcloud.controller;

import com.itcodai.springcloud.entity.TOrder;
import com.itcodai.springcloud.service.OrderService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/6/12.
 */
@RestController
@RequestMapping("/provider/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @Autowired
  private EurekaClient client;

  private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

  @GetMapping("/get/{id}")
  @ResponseBody
  @HystrixCommand
  public TOrder getOrder(@PathVariable Long id){
    TOrder tOrder = orderService.findById(id);
    if (tOrder == null) {
      throw new RuntimeException("数据库没有对应的信息");
    }
    return tOrder;
  }

  @GetMapping("/get/list")
  @ResponseBody
  @HystrixCommand
  public List<TOrder> getAll(){
    return orderService.findAll();
  }

  @GetMapping("/discovery")
  public Object discovery() {
    // 获取Eureka中所有的服务节点
    List<Application> applications = client.getApplications().getRegisteredApplications();
    if (applications != null) {
      for (Application application : applications) {
        // 对外暴露的服务名称
        String name = application.getName();
        // 只看订单服务信息
        if ("MICROSERVICE-ORDER".equals(name)) {
          // 服务有多少个实例，比如订单服务可能部署了多个，有多个订单服务注册到了eureka
          List<InstanceInfo> instances = application.getInstances();
          LOGGER.info("所有的订单服务：{}", instances);
          if (instances != null) {
            for (InstanceInfo info : instances) {
              LOGGER.info("服务id：{}", info.getInstanceId());
              LOGGER.info("服务主机：{}", info.getHostName());
              LOGGER.info("服务端口：{}", info.getPort());
            }
          }
          return instances;
        }
      }
    }
    return null;
  }

}
