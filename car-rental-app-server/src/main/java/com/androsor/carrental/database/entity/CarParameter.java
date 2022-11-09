package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The {@code CarParameter}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 21:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CarParameter implements BaseEntity<Integer> {

    @Id
    @Column(name = "car_id")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Car car;

    @Column(nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private Integer productionYear;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private Integer power;

    @Column(nullable = false)
    private String transmission;

    @Column(nullable = false)
    private Integer wheelDrive;

    @Column(nullable = false)
    private Integer numberOfDoors;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String description;

    public void setCar(Car car) {
        car.setCarParameter(this);
        this.car = car;
        this.id = car.getId();
    }
}
