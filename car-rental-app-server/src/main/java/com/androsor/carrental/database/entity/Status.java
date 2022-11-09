package com.androsor.carrental.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * The {@code Status}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 07.11.2022 22:57
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Status <T extends Serializable> implements BaseEntity<T>{

    @Column(unique = true, nullable = false)
    private String statusCode;

    @Column(nullable = false)
    private String description;
}
