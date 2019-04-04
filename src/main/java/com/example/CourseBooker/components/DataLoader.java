package com.example.CourseBooker.components;

import com.example.CourseBooker.models.Booking;
import com.example.CourseBooker.models.Course;
import com.example.CourseBooker.models.Customer;
import com.example.CourseBooker.repositories.BookingRepository.BookingRepository;
import com.example.CourseBooker.repositories.CourseRepository.CourseRepository;
import com.example.CourseBooker.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}

    public void run(ApplicationArguments applicationArguments) {
        Course course = new Course("Intro to Java", "Glasgow", 5);
        courseRepository.save(course);

        Customer customer = new Customer("Bob", "Carluke", 22);
        customerRepository.save(customer);

        Booking booking = new Booking("20-04-2019", course, customer);
        bookingRepository.save(booking);
    }
}
