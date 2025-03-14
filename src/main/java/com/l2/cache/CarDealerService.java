package com.l2.cache;

import com.l2.cache.entities.CarDealer;
import com.l2.cache.repository.CarDealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarDealerService {
    private final CarDealerRepository carDealerRepository;

    public Optional<CarDealer> findFull(String name, List<Long> carIds) {
        return carDealerRepository.findFull(name, carIds);
    }
}
