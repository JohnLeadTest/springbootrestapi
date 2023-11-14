package com.techlover.springbootrestapi.controller;

import com.techlover.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
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
//        return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "john morris").body(student);
    }

    // this returns a list of students as a json
//    http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Anna", "Morris"));
        students.add(new Student(1, "Naomi", "Morris"));
        students.add(new Student(1, "Peter", "Morris"));
        students.add(new Student(1, "Bai", "Yu"));
        students.add(new Student(1, "Stanky", "Nun"));
        return ResponseEntity.ok(students);
    }

    // spring boot rest api with path variable
//    http://localhost:8080/students/1
//    @GetMapping("/students/{id}") // {id} is a url template variable
//    public Student studentPathVariable(@PathVariable("id") int studentId) { // Pathvariable("id") is bindinf with the url template {id}
//        return new Student(studentId, "HJoih", "Morris");
//    }

//    http://localhost:8080/students/1/john
    @GetMapping("{id}/{firstName}") // {id} is a url template variable
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("firstName") String firstName) { // Pathvariable("id") is bindinf with the url template {id}
//        return new Student(studentId, firstName, "Morris");
        Student student = new Student(studentId, firstName, "Morris");
        return ResponseEntity.ok(student);
    }

    //. handle query parameters
//    http://localhost:8080/students/query?id=10
//    @GetMapping("students/query")
//    public Student studentRequestVariable(@RequestParam int id) { // we bind with the query params with the @ReqParam
//        return new Student(id, "HJoih", "Morris");
//    }

    //    http://localhost:8080/students/query?id=10&firstName=Peter
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName) { // we bind with the query params with the @ReqParam
//        return new Student(id, firstName, "Morris");
        Student student = new Student(id, firstName, "Morris");
        return ResponseEntity.ok(student);
    }

//    HTTP POST method
//    http://localhost:8080/students/create
//    {
//        "id": 1,
//            "firstName": "JOhn",
//            "lastName":  "Morris"
//    }

    // spring boot to handle POST request - create a new resource
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED) // this returns 201
    public ResponseEntity<Student> createStudent(@RequestBody Student student) { // reqBody retrieves http request body convert to javaobject (student)
        System.out.println(student.getId()+" "+ student.getFirstName() + " - " + student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
//        return student;
    }

    // spring boot to handle put request - update existing resource
    //    HTTP PUT method
//    http://localhost:8080/students/1/update
//    {
//            "firstName": "JOhn",
//            "lastName":  "Morris"
//    }
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id,  @RequestBody  Student student) {
        System.out.println(student.getId()+" "+ student.getFirstName() + " - " + student.getLastName());
//        return student;
        return ResponseEntity.ok(student);
    }


    // spring boot to handle delete request - delete existing resource
//    http://localhost:8080/students/1/delete
    @DeleteMapping("{id}/delete")
    public  ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return ResponseEntity.ok("deleted student " + studentId) ;
    }
}
