package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/{id}")
    public Car getCarByID(@PathVariable Long id) {
        return carRepository.findById(id).get();
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
