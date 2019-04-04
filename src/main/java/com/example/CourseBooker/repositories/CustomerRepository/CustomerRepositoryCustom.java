package com.example.CourseBooker.repositories.CustomerRepository;

import com.example.CourseBooker.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findCustomersByCourse(Long courseID);

    List<Customer> findCustomerByTownAndCourse(String town, Long courseID);

    List<Customer> findCustomerOverAgeByTownAndCourse(int age, String town, Long courseID);

}
