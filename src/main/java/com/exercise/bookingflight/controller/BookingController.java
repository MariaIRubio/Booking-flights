package com.exercise.bookingflight.controller;


import com.exercise.bookingflight.model.BookingDetails;
import com.exercise.bookingflight.model.Passenger;
import com.exercise.bookingflight.repo.BookingDetailsRepo;
import com.exercise.bookingflight.repo.PassengerRepo;
import com.exercise.bookingflight.service.BookingService;
import com.exercise.bookingflight.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookingController {

    @Autowired
    PassengerRepo passengerRepo;
    @Autowired
    BookingDetailsRepo bookingDetailsRepo;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private PassengerService passengerService;


    @GetMapping("/reservation")
    public String makeReservation(Model model){
        model.addAttribute("booking", new BookingDetails());
        return "reservation-form";
    }

    @PostMapping("/processForm")
    public String processData(@Valid @ModelAttribute("booking") BookingDetails booking, BindingResult binder, RedirectAttributes redirectAttributes){
        if(binder.hasErrors()){
            return "reservation-form";
        }else{
           Passenger passenger = new Passenger();
            passenger.setFirstName(booking.getPassenger().getFirstName());
            passenger.setLastName(booking.getPassenger().getLastName());
            passenger.setEmail(booking.getPassenger().getEmail());
            passenger.setPhoneNumber(booking.getPassenger().getPhoneNumber());
            booking.setPassenger(passenger);
            passengerRepo.save(passenger);
            BookingDetails savedBooking = bookingDetailsRepo.save(booking);

            Long bookingId = savedBooking.getId();

            redirectAttributes.addAttribute("bookingId", bookingId);
            return "redirect:/booking-details";
        }
    }

    @GetMapping("/booking-details")
    public String displayBooking(@RequestParam("bookingId") Long bookingId, Model model){
        if(bookingId == null){
            return "bookingid-error-page";
        }
        BookingDetails bookingDetails = bookingService.getBookingDetails(bookingId);
        if(bookingDetails == null){
            return "bookingdetails-error-page";
        }
        Passenger passenger = passengerService.getPassengerDetails(bookingDetails.getPassenger().getId());
        if(passenger == null){
            return "passenger-error-page";
        }

        model.addAttribute("passenger", passenger);
        model.addAttribute("booking", bookingDetails);

        return "booking-details";
    }

    @GetMapping("/error-page")
    public String error(){
        return "booking-error-page";
    }
}
