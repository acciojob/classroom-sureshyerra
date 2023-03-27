package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Student> studentHashMap = new HashMap<>();
    HashMap<String,Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> pairDb = new HashMap<>();

    public void addstudent(Student student){
        String name = student.getName();
        studentHashMap.put(name,student);

    }
    public void addteacher(Teacher teacher){
        String name = teacher.getName();
        teacherHashMap.put(name,teacher);

    }
    public void studentteacherpair(String studentname,String teachername){
        if(pairDb.containsKey(teachername)){
            List<String> movielist = pairDb.get(teachername);
            movielist.add(studentname);
            return;
        }
        List<String> movielist = new ArrayList<>();
        movielist.add(studentname);
        pairDb.put(teachername,movielist);
        return;

    }
    public Student getStudentByName(String name){
        Student student = studentHashMap.get(name);
        return student;
    }
    public Teacher getTeacherByName(String name){
        Teacher teacher = teacherHashMap.get(name);
        return teacher;
    }

    public List<String> getStudentsbyteachername(String name){
        if(pairDb.containsKey(name)){
            return pairDb.get(name);
        }
        return new ArrayList<>();
    }
    public List<String> getallstudents(){
        List<String> students = new ArrayList<>();
        for(String s: studentHashMap.keySet()){
            students.add(s);
        }
        return students;
    }
    public void deleteteacherbyname(String name){
        teacherHashMap.remove(name);
        List<String> students = pairDb.get(name);
        pairDb.remove(name);
        for(String s : students){
            if(s.equals(name)){
                studentHashMap.remove(s);
            }
        }

    }
    public void deleteAll(){
        for(List<String> s : pairDb.values()){
            for(String students : s){
                studentHashMap.remove(students);
            }
        }
        teacherHashMap.clear();
        pairDb.clear();
    }
}
