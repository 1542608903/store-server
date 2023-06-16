package com.store.storevue.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storevue.mapper.OrderProductMapper;
import com.store.storevue.mapper.ProductMapper;
import com.store.storevue.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;
    private final OrderProductMapper orderProductMapper;
    @Autowired
    public ProductService(ProductMapper productMapper,OrderProductMapper orderProductMapper ) {
        this.productMapper = productMapper;
        this.orderProductMapper = orderProductMapper;
    }

    public Product getProductById(int id) {
        return productMapper.selectById(id);
    }
    //    修改商品
    public Product updateProduct(Integer gid, Product product) {
        product.setId(gid); // 设置商品ID
        productMapper.updateById(product); // 使用 MyBatis-Plus 提供的 updateById 方法更新商品信息
        return product;
    }

    public void saveProduct(Product product) {
        productMapper.insert(product);
    }

    public Product addProduct(Product product) {
        productMapper.insert(product);
        return product;
    }
//    查询所有商品
    public List<Product> getAllProduct() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("stock >= 0"); // 库存小于等于0的条件过滤
        return productMapper.selectList(null);
    }
//    删除商品
    public boolean deleteProductById(Long gid) {
        int result = productMapper.deleteById(gid);
        return result > 0;
    }

    public void save(Product product) {
        productMapper.insert(product);
    }

//    通过分类id查询商品列表
    public List<Product> getProductsByCategoryId(Integer classifyId) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("classify_id",classifyId);
        queryWrapper.gt("stock", 0); // 库存大于0的条件过滤
        return productMapper.selectList(queryWrapper);
    }
//    新品列表
    public List<Product> getLatestProducts() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time"); // 按照时间倒序排序
        queryWrapper.last("LIMIT 7"); // 限制返回的数据行数
        queryWrapper.gt("stock", 0); // 库存大于0的条件过滤
        return productMapper.selectList(queryWrapper);
    }
//    热销
    public List<Product> getTopSellingGoods() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        return productMapper.findTopSellingGoods();
    }
}
