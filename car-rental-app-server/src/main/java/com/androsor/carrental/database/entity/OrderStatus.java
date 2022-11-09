package com.androsor.carrental.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The {@code OrderStatus}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 22:54
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderStatus extends Status<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
