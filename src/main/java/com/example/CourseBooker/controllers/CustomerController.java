package com.example.CourseBooker.controllers;

import com.example.CourseBooker.models.Customer;
import com.example.CourseBooker.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/course/{id}")
    List<Customer> getCustomersByCourseID(@PathVariable Long id){
        return customerRepository.findCustomersByCourse(id);
    }

    @GetMapping(value = "/town/{town}/course/{id}")
    List<Customer> getCustomerByTownAndCourse(@PathVariable String town, @PathVariable Long id){
        return customerRepository.findCustomerByTownAndCourse(town, id);
    }

    @GetMapping(value = "/age/{age}/town/{town}/course/{id}")
    List<Customer> getCustomerOverAgeByTownAndCourse(@PathVariable int age, @PathVariable String town, @PathVariable Long id){
        return customerRepository.findCustomerOverAgeByTownAndCourse(age, town, id);
    }

}
