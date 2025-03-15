package com.l2.cache;

import com.l2.cache.entities.CarDealer;
import com.l2.cache.repository.CarDealerRepository;
import com.l2.cache.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarDealerService {
    private final CarDealerRepository carDealerRepository;
    private final CarRepository carRepository;

    public Optional<CarDealer> findFull(String name, List<Long> carIds) {
        return carDealerRepository.findFull(name, carIds);
    }
}
