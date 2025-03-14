package com.l2.cache.listener;

import com.l2.cache.repository.CarDealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartupListener {

    private final CarDealerRepository carDealerRepository;

    @EventListener
    public void onStartup(ApplicationReadyEvent e) {
        String name = "targoviste";

        System.out.println(carDealerRepository.findFull(name, List.of(1L, 2L, 3L)));

        System.out.println(carDealerRepository.findFull(name, List.of(1L, 2L, 3L)));

        System.out.println(carDealerRepository.findFull(name, List.of(1L)));

    }

}
