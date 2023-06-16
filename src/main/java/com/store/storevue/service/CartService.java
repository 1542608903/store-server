package com.store.storevue.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storevue.mapper.CartMapper;
import com.store.storevue.mapper.ProductMapper;
import com.store.storevue.pojo.Cart;
import com.store.storevue.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class CartService {

    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    @Autowired
    public CartService(CartMapper cartMapper, ProductMapper productMapper) {
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }
    public void addToCart(Cart cart) {
        Cart existingItem = cartMapper.selectOne(
//            查询是否存在商品
        new QueryWrapper<Cart>()
                .eq("product_id", cart.getProductId())
                .eq("user_id", cart.getUserId()) // 添加用户ID的查询条件
        );
        System.out.println("购物车内容：" + existingItem);
        if (existingItem != null) {
//           如果存在执行修改
            existingItem.setQuantity(cart.getQuantity());
            cartMapper.updateById(existingItem);
        } else {
//          不存在执行插入
            cartMapper.insert(cart);
        }
    }
    public List<Product> getProductsAndQuantityByUserId(Integer userId) {
        return cartMapper.getProductsAndQuantityByUserId(userId);
    }

    //    删除购物车商品
    public boolean deleteCartItemByProductId(Integer productId) {
        cartMapper.deleteCartItemByProductId(productId);
        return true;
    }
    public void deleteCartItemsByUserId(Integer userId) {
        cartMapper.delete(new QueryWrapper<Cart>().eq("user_id", userId));
    }

}
