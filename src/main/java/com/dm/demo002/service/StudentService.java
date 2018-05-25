package com.dm.demo002.service;

import com.dm.demo002.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService {

    @Select("select * from student where password=#{password}")
    Student findOne(String password);

    @Select("SELECT * from  student order by id desc LIMIT 1,2")
    List<Student> findAll(Integer pageindex,Integer pagesize);

    @Insert("insert into student(id,age,name,sex,password) values(#{id},#{age},#{name},#{sex},#{password})")
    void addUser(Student student);





}
