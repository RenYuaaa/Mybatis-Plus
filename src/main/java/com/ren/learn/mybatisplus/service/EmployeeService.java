package com.ren.learn.mybatisplus.service;

import com.ren.learn.mybatisplus.beans.Employee;

import java.util.List;

/**
 * @author : renjiahui
 * @date : 2021/1/19 23:19
 * @desc :
 */
public interface EmployeeService {

    List<Employee> findAll();

    void save(Employee employee);
}
