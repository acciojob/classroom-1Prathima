package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String,Student> studentDb = new HashMap<>();
    HashMap<String,Teacher> teacherDb = new HashMap<>();
    HashMap<String, String> studentTeacherPair = new HashMap<>();

    public void addStudent(Student student){
        String key = student.getName();
        studentDb.put(key, student);
    }

    public void addTeacher(Teacher teacher){
        String key = teacher.getName();
        teacherDb.put(key, teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentTeacherPair.put(student, teacher);
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
        List<String> ans = new ArrayList<>();
        for(String student : studentTeacherPair.keySet()){
            if(studentTeacherPair.get(student).equals(name)){
                ans.add(student);
            }
        }
        return ans;
    }

    public List<String> getAllStudents(){
        List<String> ans = new ArrayList<>();
        for(String student : studentDb.keySet()){
            ans.add(student);
        }
        return ans;
    }

    public void deleteTeacherByName(String name){
        teacherDb.remove(name);
        for(String student : studentTeacherPair.keySet()){
            if(studentTeacherPair.get(student).equals(name)){
                studentDb.remove(student);
                studentTeacherPair.remove(student);
            }
        }
    }

    public void deleteAllTeachers(){
        for(String teacher : teacherDb.keySet()){
            teacherDb.remove(teacher);
            for(String student : studentTeacherPair.keySet()){
                if(studentTeacherPair.get(student).equals(teacher)){
                    studentDb.remove(student);
                    studentTeacherPair.remove(student);
                }
            }
        }
    }
}
