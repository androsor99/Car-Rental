package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The {@code Brand}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 18:36
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Brand implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;
}
