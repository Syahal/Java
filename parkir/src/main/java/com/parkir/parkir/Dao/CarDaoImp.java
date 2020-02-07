package com.parkir.parkir.Dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.parkir.parkir.Dto.AddCarDto;
import com.parkir.parkir.Dto.CarCount;
import com.parkir.parkir.Dto.SummaryDto;
import com.parkir.parkir.Model.Car;
import com.parkir.parkir.Model.CarType;
import com.parkir.parkir.Model.Detail;

import org.springframework.stereotype.Repository;

/**
 * CarService
 */
@Repository("Car")
public class CarDaoImp implements CarDao {
    private static final int SIZE = 50;
    private static List<Detail> DB = new ArrayList<>(SIZE);

    @Override
    public AddCarDto insertCar(Car car) {
        Detail newData = new Detail(new Timestamp(new Date().getTime()), null, 0, car);
        DB.add(newData);
        return new AddCarDto(car.getRegNumber(), generateParkingLot(DB.indexOf(newData)),
                newData.getCheckinTimestamp());
    }

    private static String generateParkingLot(int i) {
        String parkingLot = "";
        int num = i + 1;
        if (i < 10) {
            parkingLot = "A" + num;
        } else if (i < 20) {
            parkingLot = "B" + num;
        } else if (i < 30) {
            parkingLot = "C" + num;
        } else if (i < 40) {
            parkingLot = "D" + num;
        } else {
            parkingLot = "E" + num;
        }
        return parkingLot;
    }

    @Override
    public SummaryDto checkOut(String regNumber) {
        Optional<Detail> toRemove = DB.stream().filter(det -> det.getCar().getRegNumber().equals(regNumber))
                .findFirst();
        Car car = toRemove.get().getCar();
        DB.removeIf(det -> det.getCar().getRegNumber().equals(regNumber));
        toRemove.get().setCheckoutTimestamp(new Timestamp(new Date().getTime()));
        toRemove.get().calculateTotalPayment();
        return new SummaryDto(car.getRegNumber(), toRemove.get().getCheckinTimestamp(),
                toRemove.get().getCheckoutTimestamp(), toRemove.get().getTotalPayment());
    }

    @Override
    public int findCarByType(String type) {
        // TODO Auto-generated method stub
        return (int) DB.stream().filter(det -> det.getCar().getType().equals(CarType.valueOf(type))).count();
    }

    @Override
    public CarCount findAllCarByColor(String color) {
        // TODO Auto-generated method stub
        CarCount count = new CarCount();
        List<String> cars;
        cars = DB.stream()
                 .filter(e -> e.getCar().getColor().equals(color))
                 .map(det -> det.getCar().getRegNumber())
                 .collect(Collectors.toList());
        count.setCarCount(cars);
        
        return count;
    }
    
}