package com.darc.springrestmvc.repositories;

import com.darc.springrestmvc.bootstrap.BootstrapData;
import com.darc.springrestmvc.entities.Beer;
import com.darc.springrestmvc.model.BeerStyle;
import com.darc.springrestmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
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

    @Test
    void testSaveBeerNameLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("beeeerrrr 12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890")
                    .beerStyle(BeerStyle.GOSE)
                    .upc("12345")
                    .price(new BigDecimal("9.19"))
                    .build());

            beerRepository.flush();
        });
    }

    @Test
    void testGetBeerListByName() {
        //%(wildcard) is a sql convention - any name that contains the phrase IPA
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }
}