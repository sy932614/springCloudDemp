package itcodai.springcloud.config;

import com.itcodai.springcloud.entity.TOrder;
import feign.hystrix.FallbackFactory;
import itcodai.springcloud.service.OrderClientService;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 统一处理熔断
 * OrderClientService是Feign接口，所有访问都会走feign接口
 * @author shengwu ni
 */
@Component
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService> {

  @Override
  public OrderClientService create(Throwable throwable) {
    return new OrderClientService() {

      /**
       * 当订单服务的getOrder()方法出异常后的熔断处理方法
       * @param id id
       * @return 返回信息
       */
      @Override
      public TOrder getOrder(Long id) {
        TOrder tOrder = new TOrder();
        tOrder.setId(id);
        tOrder.setName("未找到该ID的结果");
        tOrder.setPrice(0d);
        tOrder.setDbSource("No this datasource");
        return tOrder;
      }

      @Override
      public List<TOrder> getAll() {
        return null;
      }
    };
  }
}
