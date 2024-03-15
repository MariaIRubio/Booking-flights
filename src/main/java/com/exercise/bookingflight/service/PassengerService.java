package com.exercise.bookingflight.service;

import com.exercise.bookingflight.model.BookingDetails;
import com.exercise.bookingflight.model.Passenger;
import com.exercise.bookingflight.repo.BookingDetailsRepo;
import com.exercise.bookingflight.repo.PassengerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepo passengerRepo;

    public Passenger getPassengerDetails(Long passengerId){
        return passengerRepo.findById(passengerId).orElse(null);
    }
}
