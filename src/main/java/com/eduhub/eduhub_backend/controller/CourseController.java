package com.eduhub.eduhub_backend.controller;

import com.eduhub.eduhub_backend.component.Course;
import com.eduhub.eduhub_backend.component.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @GetMapping("courses")
    public ResponseEntity<List<Course>> getStudents(){
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("U23CS245","OOPS",4));
        courses.add(new Course("U23CS246","CLOUD",3));
        courses.add(new Course("U23CS247","C",3));
        courses.add(new Course("U23CS248","JAVA",4));
        courses.add(new Course("U23CS249","FSD",3));
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    @GetMapping("{coursecode}")
    public ResponseEntity<Course> getCourseByCoursecode(@PathVariable String coursecode){
        Course course = new Course(coursecode,"",0);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("{coursecode}/{coursename}/{credits}")
    public ResponseEntity<Course> getCourseByCoursecodeAndCoursenameAndCredits(@PathVariable String coursecode, @PathVariable String coursename,@PathVariable int credits){
        Course course = new Course(coursecode,coursename,credits);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @GetMapping("query")
    public ResponseEntity<Course> getCourseByQuery(@RequestParam String coursecode, @RequestParam String coursename, @RequestParam int credits){
        Course course = new Course(coursecode,coursename,credits);
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        System.out.println(course.getCoursecode());
        System.out.println(course.getCoursename());
        System.out.println(course.getCredits());
        return ResponseEntity.ok(course);
    }

    @PutMapping("{coursecode}/update")
    public ResponseEntity<Course> updateCourse(@PathVariable String coursecode, @RequestBody Course course){
        return ResponseEntity.accepted().body(course);
    }

    @DeleteMapping("{coursecode}/delete")
    public ResponseEntity<String> deleteCourse(@PathVariable String coursecode){
        return ResponseEntity.ok("Course with coursecode " + coursecode + " deleted successfully");
    }
}
