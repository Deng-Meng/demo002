///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: StudentServiceImpl
// * Author:   DM-admin
// * Date:     2018/5/18 11:24
// * Description: test
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.dm.demo002.service.impl;
//
//import com.dm.demo002.dto.StudentDto;
//import com.dm.demo002.entity.Student;
//import com.dm.demo002.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈test〉
// *
// * @author DM-admin
// * @create 2018/5/18
// * @since 1.0.0
// */
//@Service
//@Transactional(rollbackFor = Exception.class)
//public class StudentServiceImpl implements StudentService {
//    @Autowired
//    private StudentDto studentDto;
//
//    @Override
//    public Student findOne(String id) {
//        return null;
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return (List<Student>) studentDto.findAll();
//    }
//
//    @Override
//    public void addUser(Student student) {
//        studentDto.save(student);
//    }
//}