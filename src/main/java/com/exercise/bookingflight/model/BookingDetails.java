package com.exercise.bookingflight.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;

    @NotNull(message = "Date is required")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;

    @NotNull(message = "Departure is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Departure must contain only letters")
    private String departure;

    @NotNull(message = "Destination is required")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Destination must contain only letters")
    private String destination;

    @NotNull
    private String flightCompany;


    private String dietary;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="passenger_id", nullable = false)
    private Passenger passenger;

    public BookingDetails(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public void setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
    }

    public String getDietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Booking ID: " + id +
                "\nDeparture Date: " + departureDate +
                "\nArrive Date: " + returnDate +
                "\nDeparture: " + departure +
                "\nDestination: " + destination +
                "\nCompany: " + flightCompany +
                "\nDietary: " + dietary;
    }
}
