package com.itcodai.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2019/6/12.
 */
@Configuration
public class RestTmplateConfig {

  @Bean
  @LoadBalanced
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  /**
   * 指定其他负载均衡策略
   * @return IRule
   */
  /*@Bean
  public IRule myRule() {
    // 指定重试策略：随机策略
    return new RandomRule();
  }*/
}
