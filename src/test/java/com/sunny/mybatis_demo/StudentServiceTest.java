package com.sunny.mybatis_demo;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sunny.mybatis_demo.entity.PhoneNumber;
import com.sunny.mybatis_demo.entity.Student;
import com.sunny.mybatis_demo.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}

	@AfterClass
	public static void teardown() {
		studentService = null;
	}

	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(3);
		Assert.assertNotNull(student);
		System.out.println(student);
		System.out.println(student.getPhone().getAsString());
	}

	@Test
	public void testCreateStudent() {
		Student student = new Student();
		int id = 4;
		student.setName("student_" + id);
		student.setEmail("student_" + id + "gmail.com");
		student.setDob(new Date());
		student.setPhone(new PhoneNumber("86", "021", "12345678"));
		studentService.createStudent(student);
		Student newStudent = studentService.findStudentById(id);
		Assert.assertNotNull(newStudent);
	}
}
