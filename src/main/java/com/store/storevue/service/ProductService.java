package com.store.storevue.service;

import com.store.storevue.mapper.ProductMapper;
import com.store.storevue.pojo.Product;
import com.store.storevue.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
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
}
