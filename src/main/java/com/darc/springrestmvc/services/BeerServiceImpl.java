package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.Beer;
import com.darc.springrestmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get beer Id was called in service");

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Bud")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("1239")
                .price(new BigDecimal("14.23"))
                .quantityOnHand(133)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
