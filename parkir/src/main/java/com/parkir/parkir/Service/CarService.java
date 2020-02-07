package com.parkir.parkir.Service;

import com.parkir.parkir.Dao.CarDao;
import com.parkir.parkir.Dto.AddCarDto;
import com.parkir.parkir.Dto.CarCount;
import com.parkir.parkir.Dto.SummaryDto;
import com.parkir.parkir.Model.Car;
import com.parkir.parkir.Model.CarType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * CarService
 */
@Service
public class CarService {

    private final CarDao carDao;

    @Autowired
    public CarService(@Qualifier("Car") CarDao carDao) {
        this.carDao = carDao;
    }
    
    public AddCarDto checkIn(Car car) {
        return carDao.insertCar(car);
    }

    public SummaryDto checkOut(String regNum) {
        return carDao.checkOut(regNum);
    }

    public int findCarByType(String type) {
        return carDao.findCarByType(type);
    }

    public CarCount findCarByColor(String color) {
        return carDao.findAllCarByColor(color);
    }
}