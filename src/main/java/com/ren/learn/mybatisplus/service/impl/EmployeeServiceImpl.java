package com.ren.learn.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ren.learn.mybatisplus.beans.Employee;
import com.ren.learn.mybatisplus.dao.EmployeeDao;
import com.ren.learn.mybatisplus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : renjiahui
 * @date : 2021/1/19 23:20
 * @desc :
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    //切换数据源，该注解可以用在类上，也可以用在方法上，类上优于方法上
    @DS("slave_1")
    public List<Employee> findAll() {
        return employeeDao.selectList(null);
    }

    @Override
    public void save(Employee employee) {
        employeeDao.insert(employee);
    }
}
