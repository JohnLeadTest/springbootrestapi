package com.techlover.springbootrestapi.controller;

import com.techlover.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//    http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "John",
                "Morris"
        );
        return student;
    }
    // this returns a list of students as a json
//    http://localhost:8080/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Anna", "Morris"));
        students.add(new Student(1, "Naomi", "Morris"));
        students.add(new Student(1, "Peter", "Morris"));
        students.add(new Student(1, "Bai", "Yu"));
        students.add(new Student(1, "Stanky", "Nun"));
        return students;
    }

    // spring boot rest api with path variable
//    http://localhost:8080/students/1
//    @GetMapping("/students/{id}") // {id} is a url template variable
//    public Student studentPathVariable(@PathVariable("id") int studentId) { // Pathvariable("id") is bindinf with the url template {id}
//        return new Student(studentId, "HJoih", "Morris");
//    }

//    http://localhost:8080/students/1/john
    @GetMapping("/students/{id}/{firstName}") // {id} is a url template variable
    public Student studentPathVariable(@PathVariable("id") int studentId, @PathVariable("firstName") String firstName) { // Pathvariable("id") is bindinf with the url template {id}
        return new Student(studentId, firstName, "Morris");
    }

}
