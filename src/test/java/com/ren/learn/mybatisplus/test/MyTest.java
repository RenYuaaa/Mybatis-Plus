package com.ren.learn.mybatisplus.test;

/**
 * @author : renjiahui
 * @date : 2021/1/19 22:11
 * @desc :
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ren.learn.mybatisplus.beans.Employee;
import com.ren.learn.mybatisplus.dao.EmployeeDao;
import com.ren.learn.mybatisplus.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Employee> employees = employeeDao.selectList(null);
        employees.forEach(System.out::println);
    }

    /**
     * 根据Id主键查询一个
     */
    @Test
    public void testFindById() {
        Employee employee = employeeDao.selectById(1);
        System.out.println(employee);
    }

    /**
     * 条件查询，可以查看官网条件构造器、
     * @link https://mp.baomidou.com/guide/wrapper.html#abstractwrapper
     */
    @Test
    public void testFind() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        //等于查询
//        queryWrapper.eq("age", 25);

        //小于查询
//        queryWrapper.lt("age", 35);

        //小于等于
//        queryWrapper.le("age", 35);

        //大于
//        queryWrapper.gt("age", 35);

        //大于等于
//        queryWrapper.ge("age", 35);

        //ne--不等于

        List<Employee> employees = employeeDao.selectList(queryWrapper);
        employees.forEach(System.out::println);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFindLike() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        // 相当于 like % ? %, likeLeft相当于 %? -> 以?结尾的， likeRight相当于 ?% -> 以?开头
        queryWrapper.like("last_name", "bla");

        List<Employee> employees = employeeDao.selectList(queryWrapper);
        employees.forEach(System.out::println);
    }

    /**
     * 保存
     */
    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setLastName("ren");
        employee.setAge(25);
        employee.setEmail("ren@ren.com");
        employee.setGender(1);
        employeeDao.insert(employee);
    }

    /**
     * 修改
     * 基于主键id进行修改
     */
    public void testUpdateById() {
        Employee employee = employeeDao.selectById(3);
        employee.setAge(10);
        employeeDao.updateById(employee);
    }

    /**
     * 批量修改
     */
    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setAge(5);
        QueryWrapper<Employee> updateWrapper = new QueryWrapper<>();
        updateWrapper.eq("age", 35);
        employeeDao.update(employee, updateWrapper);
    }

    /**
     * 基于id删除一个
     */
    @Test
    public void testDeleteById() {
        employeeDao.deleteById(5);
    }

    /**
     * 批量删除
     */
    @Test
    public void testDelete() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 35);
        employeeDao.delete(queryWrapper);
    }

    /**
     * 分页查询
     */
    @Test
    public void testFindPage() {
        //参数1：当前页，默认1，参数2：每条条数，默认10
        IPage<Employee> page = new Page<>(1, 2);

        //查询条件
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("age", 25);

        IPage<Employee> employeeIPage = employeeDao.selectPage(page, queryWrapper);
        long total = employeeIPage.getTotal();
        System.out.println("总条数：" + total);
        employeeIPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void findAll() {
        List<Employee> employees = employeeDao.selectList(null);
        employees.forEach(System.out::println);
    }


}
