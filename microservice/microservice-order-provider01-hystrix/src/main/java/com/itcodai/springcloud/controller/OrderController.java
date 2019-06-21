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
  @HystrixCommand(fallbackMethod = "processGetOrderHystrix")
  @ResponseBody
  public TOrder getOrder(@PathVariable Long id){
    TOrder order = orderService.findById(id);
    if (order == null) {
      throw new RuntimeException("数据库没有对应的信息");
    }
    return order;
  }

  @GetMapping("/get/list")
  @ResponseBody
  public List<TOrder> getAll(){
    return orderService.findAll();
  }

  /**
   * 上面getOrder()方法出异常后的熔断处理方法
   * @param id id
   * @return 订单信息
   */
  public TOrder processGetOrderHystrix(@PathVariable Long id) {
    TOrder tOrder = new TOrder();
    tOrder.setId(id);
    tOrder.setName("未找到该ID的结果");
    tOrder.setPrice(0d);
    tOrder.setDbSource("No this datasource");
    return tOrder;
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
