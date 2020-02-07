package com.parkir.parkir.Dto;

import java.sql.Timestamp;

/**
 * AddCarDto
 */
public class AddCarDto {

    private String regNumber;
    private String parkingLot;
    private Timestamp checkinDate;

    public AddCarDto(String regNumber, String parkingLot, Timestamp checkinDate) {
        this.regNumber = regNumber;
        this.parkingLot = parkingLot;
        this.checkinDate = checkinDate;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(String parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Timestamp getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Timestamp checkinDate) {
        this.checkinDate = checkinDate;
    }
}