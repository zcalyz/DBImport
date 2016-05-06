package com.zc.ibatis;

import java.util.List;

public interface StudentDAO {
	public void addStudent(Student student);
	
	public void addStudentBySequence(Student student);
	
	public void deleteStudentById(int id);
	
	public void updateStudentById(Student student);
	
	public List<Student> queryAllStudents();
	
	public Student queryStudentById(int id);
	
	public Student queryStuentByName(String name);
}
