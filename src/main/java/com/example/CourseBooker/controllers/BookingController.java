package com.example.CourseBooker.controllers;

import com.example.CourseBooker.models.Booking;
import com.example.CourseBooker.repositories.BookingRepository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/date/{date}")
    List<Booking> getBookingByDate(@PathVariable String date){
        return bookingRepository.findBookingsByDate(date);
    }

}
