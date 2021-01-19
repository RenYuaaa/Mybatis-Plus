package com.ren.learn.mybatisplus.beans;

/**
 * @author : renjiahui
 * @date : 2021/1/19 21:32
 * @desc :
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "雇员表")
//默认将类名作为表名
@TableName(value = "tal_employee")
public class Employee {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    @TableField(value = "last_name")
    private String lastName;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别，1-男，2-女")
    private Integer gender;

    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 不映射数据库中的任何字段
     */
    @TableField(exist = false)
    private String a;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
