package com.teng.springboot.controller;

import com.teng.springboot.bean.Employee;
import com.teng.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shkstart
 * @create 2021-06-14 17:07
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){
        return  employeeService.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }

    @RequestMapping("/deleteEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmpById(id);
        return "success";
    }
}
