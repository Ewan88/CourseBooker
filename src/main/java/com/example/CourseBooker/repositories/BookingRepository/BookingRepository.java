package com.example.CourseBooker.repositories.BookingRepository;

import com.example.CourseBooker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingsByDate(String date);

}
