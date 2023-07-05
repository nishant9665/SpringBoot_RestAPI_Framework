package com.RestAPI.RESTAPI_Demo.Controller;

import com.RestAPI.RESTAPI_Demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private CourseService courseServiceObj;

    @GetMapping("/home")
    public String home() {
        return "This is home Page- Nishant 5 July";
    }

    // get the courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseServiceObj.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseServiceObj.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseServiceObj.addCourse(course);
    }
}
