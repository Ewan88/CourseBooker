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
        Course course1 = new Course("Intro to Java", "Glasgow", 5);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Bob", "Carluke", 22);
        customerRepository.save(customer1);

        Booking booking1 = new Booking("20-04-2019", course1, customer1);
        bookingRepository.save(booking1);

        Customer customer2 = new Customer("Alice", "Scotston", 20);
        customerRepository.save(customer2);

        Booking booking2 = new Booking("20-04-2019", course1, customer2);
        bookingRepository.save(booking2);
    }
}
