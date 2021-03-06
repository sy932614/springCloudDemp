package com.itcodai.springcloud.controller;

import com.itcodai.springcloud.entity.TOrder;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/6/12.
 */
@RestController
@RequestMapping("/consumer/order")
public class OrderConsumerController {

  // 订单服务提供者模块的 url 前缀
//  private static final String ORDER_PROVIDER_URL_PREFIX = "http://localhost:8001";

  private static final String ORDER_PROVIDER_URL_PREFIX = "http://MICROSERVICE-ORDER";
  @Resource
  private RestTemplate restTemplate;

  @GetMapping("/get/{id}")
  public TOrder getOrder(@PathVariable Long id) {

    return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/" + id, TOrder.class);
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/get/list")
  public List<TOrder> getAll() {
    return restTemplate.getForObject(ORDER_PROVIDER_URL_PREFIX + "/provider/order/get/list", List.class);
  }

}
