package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The {@code CarEquipment}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 20:58
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CarEquipment implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    private Equipment equipment;

    public void setCar(Car car) {
        this.car = car;
        this.car.getCarEquipments().add(this);
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
        this.equipment.getCarEquipments().add(this);
    }
}
