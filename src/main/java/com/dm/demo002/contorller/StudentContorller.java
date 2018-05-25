/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: StudentContorller
 * Author:   DM-admin
 * Date:     2018/5/18 11:35
 * Description: test
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.dm.demo002.contorller;

import com.dm.demo002.entity.Student;
import com.dm.demo002.service.StudentService;
import com.dm.demo002.uitl.Md5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈test〉
 *
 * @author DM-admin
 * @create 2018/5/18
 * @since 1.0.0
 */
@RestController
@Transactional(rollbackFor = Exception.class)
public class StudentContorller {
    @Resource
    private StudentService studentService;

//    private Md5Encryption md5Encryption =new Md5Encryption();


    @RequestMapping("/add")
    public ResponseEntity addUser(Student student) {
        student.setPassword(Md5Encryption.str2MD5(student.getPassword()));
        studentService.addUser(student);
        return new ResponseEntity("添加成功", HttpStatus.OK);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResponseEntity query(String password) {
        Student student = studentService.findOne(Md5Encryption.str2MD5(password));
        if (student == null) {

            return new ResponseEntity("密码错误", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(student, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    public ResponseEntity queryall(Integer pageindex,Integer pagesize) {
        List<Student> students = studentService.findAll(pageindex, pagesize);
        return new ResponseEntity(students, HttpStatus.OK);

    }


}