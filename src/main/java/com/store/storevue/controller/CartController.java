package com.store.storevue.controller;

import com.store.storevue.Utils.ApiResponse;
import com.store.storevue.pojo.Cart;
import com.store.storevue.pojo.Product;
import com.store.storevue.service.CartService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = " 购物车测试接口")
@RestController
@RequestMapping("/api")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addCart")
    public ApiResponse addToCart(@RequestBody Cart cart) {
        System.out.println(cart);
        try {
            cartService.addToCart(cart);
            return new ApiResponse<>(true, "添加到购物车成功", null);
        } catch (Exception e) {
            return new ApiResponse<>(false, "添加到购物车失败", null);
        }
    }

    @GetMapping("/cartList/{userId}")
    public List<Product> getProductsAndQuantityByUserId(@PathVariable Integer userId) {
        return cartService.getProductsAndQuantityByUserId(userId);
    }

    //    删除购物车商品
    @DeleteMapping("/delete/cart/{productId}")
    public String deleteCart(@PathVariable Integer productId) {
        boolean result = cartService.deleteCartItemByProductId(productId);
        if (result) {
            return "删除成功";
        } else {
            return "删除失败.";
        }
    }
}
