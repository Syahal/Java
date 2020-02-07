package com.parkir.parkir.Dao;

import com.parkir.parkir.Dto.AddCarDto;
import com.parkir.parkir.Dto.CarCount;
import com.parkir.parkir.Dto.SummaryDto;
import com.parkir.parkir.Model.Car;


/**
 * CarDao
 */
public interface CarDao {

    AddCarDto insertCar(Car car);
    SummaryDto checkOut(String regNumber);
    int findCarByType(String type);
    CarCount findAllCarByColor(String color);
}