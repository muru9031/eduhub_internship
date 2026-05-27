package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"ram");
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"ram"));
        students.add(new Student(2,"rohit"));
        students.add(new Student(3,"ravi"));
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("{id}/{name}")
    public ResponseEntity<Student> getStudentByIdAndName(@PathVariable int id, @PathVariable String name){
        Student student = new Student(id,name);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @GetMapping("query")
    public ResponseEntity<Student> getStudentByQuery(@RequestParam int id, @RequestParam String name){
        Student student = new Student(id,name);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        return ResponseEntity.ok(student);
    }

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        return ResponseEntity.accepted().body(student);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        return ResponseEntity.ok("Student with id " + id + " deleted successfully");
    }
}
