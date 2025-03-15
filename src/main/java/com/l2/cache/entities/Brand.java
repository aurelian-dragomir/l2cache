package com.l2.cache.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Accessors(fluent = true)
@ToString(exclude = "carDealer")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRAND_id_gen")
    @SequenceGenerator(name = "BRAND_id_gen", sequenceName = "BRAND_seq", allocationSize = 1)
    private Long id;

    @NaturalId
    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Car> cars = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_dealer_id", referencedColumnName = "id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private CarDealer carDealer;
}
