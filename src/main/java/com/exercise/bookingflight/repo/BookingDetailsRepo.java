package com.exercise.bookingflight.repo;

import com.exercise.bookingflight.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailsRepo extends JpaRepository<BookingDetails, Long> {
}
