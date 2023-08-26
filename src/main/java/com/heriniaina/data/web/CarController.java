package com.heriniaina.data.web;

import com.heriniaina.data.domain.Car;
import com.heriniaina.data.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

}
