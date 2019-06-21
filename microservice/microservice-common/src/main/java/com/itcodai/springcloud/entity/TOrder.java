package com.itcodai.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/6/12.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TOrder {

  private Long id; // 主键id
  private String name; // 商品名称
  private Double price; // 商品价格
  private String dbSource; // 所存的数据库

}
