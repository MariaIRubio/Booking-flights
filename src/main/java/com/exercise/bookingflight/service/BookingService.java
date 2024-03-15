package com.exercise.bookingflight.service;

import com.exercise.bookingflight.model.BookingDetails;
import com.exercise.bookingflight.repo.BookingDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingDetailsRepo bookingDetailsRepo;

    public BookingDetails getBookingDetails(Long bookingId){
        BookingDetails bookingDetails = new BookingDetails();
        return bookingDetailsRepo.findById(bookingId).orElse(null);
    }
}
