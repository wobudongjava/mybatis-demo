package com.sunny.mybatis_demo.dao;

import java.util.List;

import com.sunny.mybatis_demo.entity.Student;

public interface StudentMapper {
	List<Student> findAllStudents();

	Student findStudentById(Integer id);

	void insertStudent(Student student);
}
