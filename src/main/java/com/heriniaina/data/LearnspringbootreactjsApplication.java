package com.heriniaina.data;

import com.heriniaina.data.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class LearnspringbootreactjsApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(LearnspringbootreactjsApplication.class);
    @Autowired
    private CarRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(LearnspringbootreactjsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner("John", "Doe");
        Owner owner1 = new Owner("Pascal", "Mathieu");
        ownerRepository.saveAll(Arrays.asList(owner1, owner));
        repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 59000, 2021, owner));
        repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 29000, 2019, owner1));
        repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 39000, 2020, owner1));

        userRepository.save(new User("heriniaina",passwordEncoder.encode("heriniaina"),"admin"));
        userRepository.save(new User("user",passwordEncoder.encode("heriniaina"),"user"));
        for (Car car : repository.findAll()) {
            LOGGER.info(car.getBrand() + " " + car.getModel());
        }
    }
}
