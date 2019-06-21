package com.itcodai.springcloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/6/14.
 */
@Configuration
public class MyRuleConfig {

  @Bean
  public IRule myselfRule() {
    // 指定策略：我们自定义的策略
    return new CustomRule();
  }

}
