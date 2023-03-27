package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addstudent(student);

    }
    public void addTeacher(Teacher teacher){
        studentRepository.addteacher(teacher);
    }
    public void studentTeacherPair(String studentName,String teacherName){
        studentRepository.studentteacherpair(studentName,teacherName);
    }
    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);

    }
    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);

    }
    public List<String> getstudentsbyteachername(String name){
        return studentRepository.getStudentsbyteachername(name);
    }
    public List<String >getallstudents(){
        return studentRepository.getallstudents();
    }
    public void deleteteacherbyname(String name){
        studentRepository.deleteteacherbyname(name);
    }
    public void deleteallteachers(){
        studentRepository.deleteAll();
    }
}
