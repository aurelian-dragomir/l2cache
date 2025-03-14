package com.l2.cache.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NaturalId;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table
@Getter
@Setter
@Accessors(fluent = true)
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CarDealer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_DEALER_id_gen")
    @SequenceGenerator(name = "CAR_DEALER_id_gen", sequenceName = "CAR_DEALER_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    private String name;

    @OneToMany(mappedBy = "carDealer")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Brand> brands = new LinkedHashSet<>();

}
