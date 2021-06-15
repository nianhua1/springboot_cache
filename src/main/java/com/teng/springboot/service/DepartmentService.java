package com.teng.springboot.service;

import com.teng.springboot.bean.Department;
import com.teng.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-06-15 20:46
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Qualifier("deptRedisCacheManager")
    @Autowired
    private RedisCacheManager deptRedisCacheManager;
//
//    @Cacheable(cacheNames = "dept",cacheManager = "deptRedisCacheManager")
//    public Department getDeptById(Integer id){
//        return departmentMapper.getDeptById(id);
//    }

    public Department getDeptById(Integer id){
        Department dept = departmentMapper.getDeptById(id);
        Cache cache = deptRedisCacheManager.getCache("dept");
        cache.put("dept:1",dept);
        return dept;
    }
}
