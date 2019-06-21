package com.itcodai.springcloud.service;

import com.itcodai.springcloud.entity.TOrder;
import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */

public interface OrderService {

  TOrder findById(Long id);

  List<TOrder> findAll();



}
