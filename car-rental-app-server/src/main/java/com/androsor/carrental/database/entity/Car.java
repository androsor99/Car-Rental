package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Car}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 18:43
 */

@Data
@EqualsAndHashCode(of = "registrationNo")
@ToString(exclude = {"carEquipments", "carParameter"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Car implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String registrationNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private BigDecimal dailyFee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    private CarStatus status;

    private Boolean bestOffer;

    @Builder.Default
    @OneToMany(mappedBy = "car")
    private List<CarEquipment> carEquipments = new ArrayList<>();

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private CarParameter carParameter;
}
