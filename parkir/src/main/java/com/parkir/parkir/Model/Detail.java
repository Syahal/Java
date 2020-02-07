package com.parkir.parkir.Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * CheckIn
 */
public class Detail {
    private Timestamp checkinTimestamp;
    private Timestamp checkoutTimestamp;
    private int totalPayment = 0;
    private Car car;
    
    public void calculateTotalPayment() {
        int hourlyRate = 0;
        int diff = 0;
        double interestPerHour = 0.2;
        LocalDateTime dateIn;
        LocalDateTime dateOut;
        switch (car.getType()) {
            case SUV:
                hourlyRate = 25000;
                dateIn = checkinTimestamp.toLocalDateTime();
                dateOut = checkoutTimestamp.toLocalDateTime();
                diff= dateOut.getHour() - dateIn.getHour();
                totalPayment += hourlyRate; // first one hour
                for(int i = 1; i <= diff - 1; i++) {
                    totalPayment += hourlyRate * interestPerHour;
                }
                break;
            case MPV:
                hourlyRate = 35_000;
                dateIn = checkinTimestamp.toLocalDateTime();
                dateOut = checkoutTimestamp.toLocalDateTime();
                diff= dateOut.getHour() - dateIn.getHour();
                totalPayment += hourlyRate; // first one hour
                for(int i = 1; i <= diff -1; i++) {
                    totalPayment += hourlyRate * interestPerHour;
                }
            default:
                break;
        }
    }

    public Detail(Timestamp checkinTimestamp, Timestamp checkoutTimestamp, int totalPayment, Car car) {
        this.checkinTimestamp = checkinTimestamp;
        this.checkoutTimestamp = checkoutTimestamp;
        this.totalPayment = totalPayment;
        this.car = car;
    }

    public Timestamp getCheckinTimestamp() {
        return checkinTimestamp;
    }

    public void setCheckinTimestamp(Timestamp checkinTimestamp) {
        this.checkinTimestamp = checkinTimestamp;
    }

    public Timestamp getCheckoutTimestamp() {
        return checkoutTimestamp;
    }

    public void setCheckoutTimestamp(Timestamp checkoutTimestamp) {
        this.checkoutTimestamp = checkoutTimestamp;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}