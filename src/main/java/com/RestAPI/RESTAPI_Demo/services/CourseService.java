package com.RestAPI.RESTAPI_Demo.services;

import com.RestAPI.RESTAPI_Demo.Controller.*;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course getCourse(long courseId);

    Course addCourse(Course course);
}
