package com.example.CourseBooker.repositories.CourseRepository;

import com.example.CourseBooker.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findCourseByCustomer(Long customerID);

}
