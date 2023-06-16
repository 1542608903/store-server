package com.store.storevue.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storevue.pojo.Order;
import com.store.storevue.pojo.OrderProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("SELECT o.id, o.user_id, o.order_date, o.total " +
            "FROM order_info o " +
            "LEFT JOIN order_product op ON o.id = op.order_id " +
            "WHERE o.user_id = #{userId} " +
            "GROUP BY o.id, o.user_id, o.order_date, o.total")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "orderDate", column = "order_date"),
            @Result(property = "total", column = "total"),
            @Result(property = "orderProducts", column = "id", many = @Many(select = "com.store.storevue.mapper.OrderProductMapper.selectByOrderId"))
    })
    List<Order> selectOrdersWithDetailsByUserId(@Param("userId") Integer userId);


}
