package com.store.storevue.controller;

import com.store.storevue.pojo.Product;
import com.store.storevue.pojo.User;
import com.store.storevue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public String insertProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "商品插入成功";
    }
//    查询商品列表
    @GetMapping("/productlist")
    public List<Product> getProduct(){
        List<Product> productList = productService.getAllProduct();
        return productList;
    }

//    删除商品
    @DeleteMapping("/product/{gid}")
    public String deleteProduct(@PathVariable Integer gid) {
        boolean result = productService.deleteProductById(Long.valueOf(gid));
        if (result) {
            return "删除成功";
        } else {
            return "删除失败.";
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return ResponseEntity.ok(createdProduct);
    }
//    修改商品信息
    @PutMapping("/update/product/{gid}" )
    public Product updateProduct(@PathVariable Integer gid, @RequestBody Product product) {
        System.out.println("商品id"+gid);
        return productService.updateProduct(gid, product);
    }
}
