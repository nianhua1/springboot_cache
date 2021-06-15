package com.teng.springboot.controller;

import com.teng.springboot.bean.Department;
import com.teng.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-06-15 20:48
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }
}
