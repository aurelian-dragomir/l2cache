package com.l2.cache.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.NaturalId;

@Entity
@Table
@Getter
@Setter
@Accessors(fluent = true)
@ToString(exclude = "brand")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_id_gen")
    @SequenceGenerator(name = "CAR_id_gen", sequenceName = "CAR_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Brand brand;

    private Boolean active;
}
