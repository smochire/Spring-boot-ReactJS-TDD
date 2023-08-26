package com.heriniaina.data.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;
    private String model;
    private String color;
    private String registerNumber;
    private Integer price;
    @Column(name = "annee")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "owner", referencedColumnName = "ownerId")
    private Owner owner;

    public Car(String brand, String model, String color, String registerNumber, Integer price, Integer year, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.price = price;
        this.year = year;
        this.owner = owner;
    }
}
