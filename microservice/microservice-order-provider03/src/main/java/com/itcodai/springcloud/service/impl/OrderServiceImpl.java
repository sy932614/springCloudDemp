package com.itcodai.springcloud.service.impl;

import com.itcodai.springcloud.dao.OrderMapper;
import com.itcodai.springcloud.entity.TOrder;
import com.itcodai.springcloud.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/6/12.
 */
@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderMapper orderMapper;

  @Override
  public TOrder findById(Long id) {
    return orderMapper.findById(id);
  }

  @Override
  public List<TOrder> findAll() {
    return orderMapper.findAll();
  }
}
