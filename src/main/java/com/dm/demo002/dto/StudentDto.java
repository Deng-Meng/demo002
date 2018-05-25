package com.dm.demo002.dto;

import com.dm.demo002.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentDto extends CrudRepository<Student,Integer>,PagingAndSortingRepository<Student,Integer> {
}
