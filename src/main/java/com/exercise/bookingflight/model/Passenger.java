package com.exercise.bookingflight.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Name must contain only letters")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Last name must contain only letters")
    private String lastName;

    @NotNull(message = "Email is required")
    @Size(min = 1, message = "Email required")
    private String email;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{9}", message = "Phone must contain at least 9 digits")
    private String phoneNumber;

    public Passenger(){}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
//
//   // public BookingDetails getBookingDetails() {
//        return bookingDetails;
//    }

//    public void setBookingDetails(BookingDetails bookingDetails) {
//        this.bookingDetails = bookingDetails;
//    }
//
    @Override
    public String toString() {
        return "Passenger ID: " + id +
                "\nName: " + firstName +
                " " + lastName +
                "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber;
    }
}
