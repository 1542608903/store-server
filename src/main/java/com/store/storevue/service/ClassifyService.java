package com.store.storevue.service;

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
    public List<Classify> getAllClassify() {
        return classifyMapper.selectList(null);
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
