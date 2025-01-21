package com.travifai.preferences_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Document(collection = "preferences")
public class Preference {
    @Id
    private String id;
    private String location;
    private int numberOfPersons;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int roomNumbers;
    private int numberOfNights; // Auto-calculated

    // ✅ Constructor
    public Preference() {}

    // ✅ Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getNumberOfPersons() { return numberOfPersons; }
    public void setNumberOfPersons(int numberOfPersons) { this.numberOfPersons = numberOfPersons; }

    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { 
        this.checkInDate = checkInDate;
        calculateNumberOfNights(); // Auto-update nights
    }

    public LocalDate getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate) { 
        this.checkOutDate = checkOutDate;
        calculateNumberOfNights(); // Auto-update nights
    }

    public int getRoomNumbers() { return roomNumbers; }
    public void setRoomNumbers(int roomNumbers) { this.roomNumbers = roomNumbers; }

    public int getNumberOfNights() { return numberOfNights; }

    // ✅ Auto-calculate number of nights
    public void calculateNumberOfNights() {
        if (checkInDate != null && checkOutDate != null) {
            this.numberOfNights = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        }
    }
}
