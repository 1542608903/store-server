package com.store.storevue.controller;

import com.store.storevue.mapper.OrderProductMapper;
import com.store.storevue.pojo.OrderProduct;
import com.store.storevue.pojo.Product;
import com.store.storevue.service.OrderService;
import com.store.storevue.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = " 商品测试接口")
@RestController
@RequestMapping("/api")
public class ProductController {

//    @Autowired
    private final ProductService productService;
    private final OrderService orderService;
    private final OrderProductMapper orderProductMapper;
    @Autowired
    public ProductController(OrderService orderService,ProductService productService,OrderProductMapper orderProductMapper) {
        this.orderService = orderService;
        this.productService=productService;
        this.orderProductMapper = orderProductMapper;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products/add")
    public String insertProduct(@RequestBody Product product) {
        productService.saveProduct(product);
//        product.setCreateTime(new Date());
        return "商品插入成功";
    }
//    查询商品列表
    @GetMapping("/product/list")
    public List<Product> getProduct(){
        List<Product> productList = productService.getAllProduct();
        return productList;
    }

//    新品列表
@GetMapping("/newProduct/list")
    public List<Product> getLatestProducts(){
    return productService.getLatestProducts();
    }
//    删除商品
    @DeleteMapping("/delete/product/{gid}")
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
        return productService.updateProduct(gid, product);
    }

//    通过分类id查询商品
    @GetMapping("/productByClassifyId/{classifyId}")
    public List<Product> getProductsByCategoryId(@PathVariable Integer classifyId) {
        System.out.println("分类id="+classifyId);
        return productService.getProductsByCategoryId(classifyId);
    }
//热销
    @GetMapping("/product/highest-sales")
    public List<Product> getTopSellingGoods() {
        return productService.getTopSellingGoods();
    }
}
