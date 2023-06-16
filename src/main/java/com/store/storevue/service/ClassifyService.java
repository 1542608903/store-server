package com.store.storevue.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.store.storevue.mapper.ClassifyMapper;
import com.store.storevue.pojo.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyService {

    private final ClassifyMapper classifyMapper;
    @Autowired
    public ClassifyService(ClassifyMapper classifyMapper) {
        this.classifyMapper = classifyMapper;
    }
//    查询所有分类
    public List<Classify> getAllClassify() {
        QueryWrapper<Classify> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("classify_id"); // 倒序排序
        return classifyMapper.selectList(queryWrapper);
    }
//插入分类
    public void ClassifySave(Classify classify) {
        classifyMapper.insert(classify);
    }
//    删除分类
    public boolean deleteClassifyById(Integer classifyId) {
        int result = classifyMapper.deleteById(classifyId);
        return result > 0;
    }
}
