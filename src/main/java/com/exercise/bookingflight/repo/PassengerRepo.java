package com.exercise.bookingflight.repo;

import com.exercise.bookingflight.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepo extends JpaRepository<Passenger, Long> {
}
