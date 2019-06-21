package itcodai.springcloud.controller;

import com.itcodai.springcloud.entity.TOrder;
import itcodai.springcloud.service.OrderClientService;
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

  @Resource
  private OrderClientService orderClientService;

  @GetMapping("/get/{id}")
  public TOrder getOrder(@PathVariable Long id) {

    return orderClientService.getOrder(id);
  }

  @SuppressWarnings("unchecked")
  @GetMapping("/get/list")
  public List<TOrder> getAll() {
    return orderClientService.getAll();
  }

}
