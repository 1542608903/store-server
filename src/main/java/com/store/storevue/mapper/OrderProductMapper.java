package com.store.storevue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storevue.pojo.OrderProduct;
import com.store.storevue.pojo.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderProductMapper extends BaseMapper<OrderProduct> {
    @Select("SELECT * FROM order_product WHERE order_id = #{orderId}")
    List<OrderProduct> selectByOrderId(Integer orderId);

    @Select("SELECT g.gid, g.name, g.cover_image, g.price, g.stock " +
            "FROM goods AS g " +
            "INNER JOIN (" +
            "    SELECT g.gid, SUM(op.quantity) AS total_sales " +
            "    FROM order_product op, goods g " +
            "    WHERE op.product_id = g.gid AND g.stock > 0 " +
            "    GROUP BY g.gid " +
            "    ORDER BY total_sales DESC " +
            "    LIMIT 0, 7" +
            ") AS op ON g.gid = op.gid")
    List<Product> findTopSellingGoods();
}
