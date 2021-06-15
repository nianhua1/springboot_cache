package com.teng.springboot.service;

import com.teng.springboot.bean.Employee;
import com.teng.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author shkstart
 * @create 2021-06-14 17:08
 */
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 几个属性：
     *      cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *
     *      key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *              编写SpEL； #i d;参数id的值   #a0  #p0  #root.args[0]
     *              getEmp[2]
     *
     *      keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *              key/keyGenerator：二选一使用;
     *
     *
     *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *
     *      condition：指定符合条件的情况下才缓存；
     *              ,condition = "#id>0"
     *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *
     *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *              unless = "#result == null"
     *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      sync：是否使用异步模式
     * @param id
     * @return
     */
    //@Cacheable(value = "emp"/*,condition = "#id>1"*/)
    @Cacheable
    public Employee getEmpById(Integer id) {
        System.out.println("查询"+id+"号员工");
        return employeeMapper.getEmpById(id);
    }

    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp",key = "#id")
    public void deleteEmpById(Integer id) {
//        employeeMapper.deleteEmpById(id);
        System.out.println("删除了"+id+"号");
    }
}
