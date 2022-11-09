package com.androsor.carrental.database.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The {@code Role}
 *
 * @author Andrei Soroka
 * @version 1.0
 * @createdAt 06.11.2022 21:23
 */
@Data
@EqualsAndHashCode(of = "type")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleType type;
}
