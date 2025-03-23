package com.darc.springrestmvc.bootstrap;

import com.darc.springrestmvc.entities.Beer;
import com.darc.springrestmvc.model.BeerStyle;
import com.darc.springrestmvc.entities.Customer;
import com.darc.springrestmvc.repositories.BeerRepository;
import com.darc.springrestmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {

        if (beerRepository.count() == 0) {

            Beer beer1 = Beer.builder()
                    .beerName("Bud")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("1239")
                    .price(new BigDecimal("14.23"))
                    .quantityOnHand(133)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Trophy")
                    .beerStyle(BeerStyle.LAGER)
                    .upc("13445")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(321)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Star")
                    .beerStyle(BeerStyle.STOUT)
                    .upc("2391")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(219)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }


    }

    private void loadCustomerData() {

        if (customerRepository.count() == 0) {

            Customer customer1 = Customer.builder()
                    .customerName("Joe")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .customerName("Kenny")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .customerName("Kim")
                    .version(1)
                    .createdDate(LocalDateTime.now())
                    .modifiedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }

    }
}
