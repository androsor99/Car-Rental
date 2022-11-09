package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The {@code Star}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 08.11.2022 21:11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Star implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @Column(nullable = false)
    private Integer stars;
}
