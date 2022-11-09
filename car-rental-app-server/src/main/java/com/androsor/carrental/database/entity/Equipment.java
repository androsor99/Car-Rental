package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Equipment}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 20:51
 */

@Data
@EqualsAndHashCode(of = "equipmentCode")
@ToString(exclude = "carEquipments")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Equipment implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String equipmentCode;

    @Column(nullable = false)
    private String description;

    @Builder.Default
    @OneToMany(mappedBy = "equipment")
    private List<CarEquipment> carEquipments = new ArrayList<>();
}
