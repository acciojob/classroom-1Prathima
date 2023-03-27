package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

//    @Autowired
    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.addTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.addStudentTeacherPair(student,teacher);
    }

    public Student getStudentByName(String name){
        Student student = studentRepository.getStudentByName(name);
        return student;
    }

    public Teacher getTeacherByName(String name){
        Teacher teacher = studentRepository.getTeacherByName(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> ans = studentRepository.getStudentsByTeacherName(name);
        return ans;
    }

    public List<String> getAllStudents(){
        List<String> ans = studentRepository.getAllStudents();
        return ans;
    }

    public void deleteTeacherByName(String name){
        studentRepository.deleteTeacherByName(name);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}
