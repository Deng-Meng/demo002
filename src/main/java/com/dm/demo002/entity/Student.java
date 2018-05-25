/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Student
 * Author:   DM-admin
 * Date:     2018/5/18 10:59
 * Description: 学生类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.entity;

//import javax.persistence.*;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈学生类〉
 *
 * @author DM-admin
 * @create 2018/5/18
 * @since 1.0.0
 */
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Integer sex;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}