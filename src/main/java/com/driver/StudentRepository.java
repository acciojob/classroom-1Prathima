package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String, List<String>> studentTeacherPair = new HashMap<>();


    public void addStudent(Student student){
        String key = student.getName();
        studentDb.put(key, student);
    }

    public void addTeacher(Teacher teacher){
        String key = teacher.getName();
        teacherDb.put(key, teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        List<String> students = studentTeacherPair.get(teacher);
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
        studentTeacherPair.put(teacher, students);
    }

    public Student getStudentByName(String name){
        Student student = studentDb.get(name);
        return student;
    }

    public Teacher getTeacherByName(String name){
        Teacher teacher = teacherDb.get(name);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String name){
        List<String> ans = studentTeacherPair.get(name);
        return ans;
    }

    public List<String> getAllStudents(){
        List<String> ans = new ArrayList<>();
        for(String student : studentDb.keySet()){
            ans.add(student);
        }
        return ans;
    }

    public void deleteTeacherByName(String teacher){
        for(String student : studentTeacherPair.get(teacher)){
            studentDb.remove(student);
        }
        teacherDb.remove(teacher);
        studentTeacherPair.remove(teacher);
    }

    public void deleteAllTeachers(){
        for(String teacher : teacherDb.keySet()){
            for(String student : studentTeacherPair.get(teacher)){
                studentDb.remove(student);
            }
            teacherDb.remove(teacher);
            studentTeacherPair.remove(teacher);
        }
    }
}
