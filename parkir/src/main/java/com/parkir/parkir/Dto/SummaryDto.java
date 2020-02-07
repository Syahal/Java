package com.parkir.parkir.Dto;

import java.sql.Timestamp;

/**
 * Parking
 */
public class SummaryDto {

    private String regNumber;
    private Timestamp in;
    private Timestamp out;
    private int totalPayment;

    public Timestamp getIn() {
        return in;
    }

    public Timestamp getOut() {
        return out;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public SummaryDto(String regNumber, Timestamp in, Timestamp out, int totalPayment) {
        this.regNumber = regNumber;
        this.in = in;
        this.out = out;
        this.totalPayment = totalPayment;
    }
}