package com.itcodai.springcloud.dao;

import com.itcodai.springcloud.entity.TOrder;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2019/6/12.
 */
public interface OrderMapper {

  @Select("select * from t_order where id = #{id}")
  TOrder findById(Long id);

  @Select("select * from t_order")
  List<TOrder> findAll();

}
