package com.techlover.springbootrestapi.controller;

import com.techlover.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
//    http://localhost:8080/student
//    @GetMapping("student")
//    public Student getStudent() {
//        Student student = new Student(
//                1,
//                "John",
//                "Morris"
//        );
//        return student;
//    }

    // replace the function using response entity
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "John",
                "Morris"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
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

    //. handle query parameters
//    http://localhost:8080/students/query?id=10
//    @GetMapping("students/query")
//    public Student studentRequestVariable(@RequestParam int id) { // we bind with the query params with the @ReqParam
//        return new Student(id, "HJoih", "Morris");
//    }

    //    http://localhost:8080/students/query?id=10&firstName=Peter
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName) { // we bind with the query params with the @ReqParam
        return new Student(id, firstName, "Morris");
    }

//    HTTP POST method
//    http://localhost:8080/students/create
//    {
//        "id": 1,
//            "firstName": "JOhn",
//            "lastName":  "Morris"
//    }

    // spring boot to handle POST request - create a new resource
    @PostMapping("/students/create")
    @ResponseStatus(HttpStatus.CREATED) // this returns 201
    public Student createStudent(@RequestBody Student student) { // reqBody retrieves http request body convert to javaobject (student)
        System.out.println(student.getId()+" "+ student.getFirstName() + " - " + student.getLastName());
        return student;
    }

    // spring boot to handle put request - update existing resource
    //    HTTP PUT method
//    http://localhost:8080/students/1/update
//    {
//            "firstName": "JOhn",
//            "lastName":  "Morris"
//    }
    @PutMapping("students/{id}/update")
    public Student updateStudent(@PathVariable("id") int id,  @RequestBody  Student student) {
        System.out.println(student.getId()+" "+ student.getFirstName() + " - " + student.getLastName());
        return student;
    }


    // spring boot to handle delete request - delete existing resource
//    http://localhost:8080/students/1/delete
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        return "deleted student " + studentId ;
    }


}
