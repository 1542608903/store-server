package com.store.storevue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storevue.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    // 可以自定义其他的商品数据访问方法

    @Select("SELECT g.gid, g.name, g.cover_image, g.price " +
            "FROM goods AS g " +
            "INNER JOIN (" +
            "    SELECT product_id, SUM(quantity) AS total_sales " +
            "    FROM order_product " +
            "    GROUP BY product_id " +
            "    ORDER BY total_sales DESC " +
            "    LIMIT 7" +
            ") AS top_product ON g.gid = top_product.product_id " +
            "WHERE g.stock > 0")
    List<Product> findTopSellingGoods();
}
