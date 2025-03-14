package com.l2.cache.repository;

import com.l2.cache.entities.CarDealer;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarDealerRepository extends JpaRepository<CarDealer, Long> {

    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @Query("from CarDealer cd join fetch cd.brands br join fetch br.cars cr where cd.name=:name and cr.id in :carIds")
    Optional<CarDealer> findFull(@Param("name") String name, @Param("carIds") List<Long> carIds);

}
