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
//    HashMap<String, String> studentTeacherPair = new HashMap<>();
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

//        teacherDb.remove(name);
//        for(String student : studentTeacherPair.keySet()){
//            if(studentTeacherPair.get(student).equals(name)){
//                studentDb.remove(student);
//                studentTeacherPair.remove(student);
//            }
//        }


        //iterate
//        for(Map.Entry<String, String> entry : studentTeacherPair.entrySet()){
//            if(entry.getValue().equals(name)){
//                String studentName = entry.getKey();
//                studentDb.remove(studentName);
//                studentTeacherPair.remove(studentName);
//            }
//        }
    }

    public void deleteAllTeachers(){

        for(String teacher : teacherDb.keySet()){
            for(String student : studentTeacherPair.get(teacher)){
                studentDb.remove(student);
            }
            teacherDb.remove(teacher);
            studentTeacherPair.remove(teacher);
        }
//        for(String teacher : teacherDb.keySet()){
//            teacherDb.remove(teacher);
//            for(String student : studentTeacherPair.keySet()){
//                if(studentTeacherPair.get(student).equals(teacher)){
//                    studentDb.remove(student);
//                    studentTeacherPair.remove(student);
//                }
//            }
//        }


        //iterate
//        for(String teacherName : teacherDb.keySet()) {
//            teacherDb.remove(teacherName);
//
//            for (Map.Entry<String, String> entry : studentTeacherPair.entrySet()) {
//                if (entry.getValue().equals(teacherName)) {
//                    String studentName = entry.getKey();
//                    studentDb.remove(studentName);
//                    studentTeacherPair.remove(studentName);
//                }
//            }
//        }
    }
}
