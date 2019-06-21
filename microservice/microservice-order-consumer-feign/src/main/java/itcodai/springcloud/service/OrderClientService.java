package itcodai.springcloud.service;

import com.itcodai.springcloud.entity.TOrder;
import itcodai.springcloud.config.OrderClientServiceFallbackFactory;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * feign客户端
 * @author shengwu ni
 */
//@FeignClient(value = "MICROSERVICE-ORDER")
@FeignClient(value = "MICROSERVICE-ORDER", fallbackFactory = OrderClientServiceFallbackFactory.class)
public interface OrderClientService {

  @GetMapping("/provider/order/get/{id}")
  TOrder getOrder(@PathVariable(value = "id") Long id);

  @GetMapping("/provider/order/get/list")
  List<TOrder> getAll();

}
