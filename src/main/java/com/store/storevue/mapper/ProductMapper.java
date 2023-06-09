package com.store.storevue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.storevue.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    // 可以自定义其他的商品数据访问方法
}
