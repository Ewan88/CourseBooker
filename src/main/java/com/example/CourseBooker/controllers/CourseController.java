package com.example.CourseBooker.controllers;

import com.example.CourseBooker.models.Course;
import com.example.CourseBooker.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/rating/{rating}")
    List<Course> getCoursesByRating(@PathVariable int rating){
        return courseRepository.findCoursesByRating(rating);
    }

    @GetMapping(value = "/customer/{id}")
    List<Course> getCoursesByCustomerID(@PathVariable Long id){
        return courseRepository.findCourseByCustomer(id);
    }
}
