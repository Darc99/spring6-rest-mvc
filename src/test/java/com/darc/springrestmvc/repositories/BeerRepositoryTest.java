package com.darc.springrestmvc.repositories;

import com.darc.springrestmvc.entities.Beer;
import com.darc.springrestmvc.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testSave() {

        Beer savedBeer = beerRepository.save(Beer.builder()
                        .beerName("derrrrr")
                        .beerStyle(BeerStyle.GOSE)
                        .upc("12345")
                        .price(new BigDecimal("9.19"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }


}