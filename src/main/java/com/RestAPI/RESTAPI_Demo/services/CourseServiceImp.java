package com.RestAPI.RESTAPI_Demo.services;

import com.RestAPI.RESTAPI_Demo.Controller.Course;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseServiceImp implements CourseService {
    public List<Course> list;

    public CourseServiceImp() {
        list = new ArrayList<>();
        list.add(new Course(145, "JAVA COURSE", "This course is basic of java"));
        list.add(new Course(2221, "Spring Boot COURSE", "This course is Spring boot details course"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {

        Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }
}
