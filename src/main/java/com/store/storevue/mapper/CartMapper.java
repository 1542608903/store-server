package com.store.storevue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storevue.pojo.Cart;
import com.store.storevue.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
    public interface CartMapper extends BaseMapper<Cart> {
    @Select("SELECT p.*, c.quantity " +
            "FROM cart c " +
            "JOIN goods p ON c.product_id = p.gid " +
            "WHERE c.user_id = #{userId}")
    List<Product> getProductsAndQuantityByUserId(@Param("userId") Integer userId);

    @Delete("DELETE FROM cart WHERE product_id = #{productId}")
    int deleteCartItemByProductId(Integer productId);

    }

