package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.BeerDTO;
import com.darc.springrestmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {

        this.beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Bud")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("1239")
                .price(new BigDecimal("14.23"))
                .quantityOnHand(133)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Trophy")
                .beerStyle(BeerStyle.LAGER)
                .upc("13445")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(321)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        BeerDTO beer3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Star")
                .beerStyle(BeerStyle.STOUT)
                .upc("2391")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(219)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize){
        return new PageImpl<>(new ArrayList<>(beerMap.values()));
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {

        log.info("Get beer by id - in service: {}", id);
        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {

        BeerDTO savedBeer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }

    @Override
    public Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer) {

       BeerDTO existingBeer = beerMap.get(beerId);
       existingBeer.setBeerName(beer.getBeerName());
       existingBeer.setBeerStyle(beer.getBeerStyle());
       existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
       existingBeer.setUpc(beer.getUpc());
       existingBeer.setPrice(beer.getPrice());

       return Optional.of(existingBeer);
//       beerMap.put(existingBeer.getId(), existingBeer);
    }

    @Override
    public Boolean deleteById(UUID beerId) {

        beerMap.remove(beerId);

        return true;
    }

    @Override
    public Optional<BeerDTO> updateBeerByPatch(UUID beerId, BeerDTO beer) {

        BeerDTO existingBeer = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getBeerName())) {
            existingBeer.setBeerName(beer.getBeerName());
        }

        if (beer.getBeerStyle() != null) {
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (beer.getPrice() != null) {
            existingBeer.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null) {
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existingBeer.setUpc(beer.getUpc());
        }

        return Optional.of(existingBeer);
    }

}
