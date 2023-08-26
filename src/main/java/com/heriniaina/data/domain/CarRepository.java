package com.heriniaina.data.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findByBrand(String brand);

    List<Car> findByColor(String color);

    List<Car> findByYear(Integer year);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandOrColor(String brand, String color);
}
