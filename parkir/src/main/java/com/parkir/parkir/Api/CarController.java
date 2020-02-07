package com.parkir.parkir.Api;

import com.parkir.parkir.Dto.AddCarDto;
import com.parkir.parkir.Dto.CarCount;
import com.parkir.parkir.Dto.SummaryDto;
import com.parkir.parkir.Model.Car;
import com.parkir.parkir.Model.CarType;
import com.parkir.parkir.Service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CarController
 */
@RequestMapping("/api/parking")
@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/checkin")
    public AddCarDto checkIn(@RequestBody Car car) {
        return carService.checkIn(car);
    }

    @PostMapping("/checkout")
    public SummaryDto checkOut(@RequestBody String regNum) {
        return carService.checkOut(regNum);
    }

    @GetMapping("/type")
    public int findCarByType(@RequestBody String type) {
        return carService.findCarByType(type);
    }

    @GetMapping("/color")
    public CarCount findCarByColor(@RequestBody String color) {
        return carService.findCarByColor(color);
    }
}