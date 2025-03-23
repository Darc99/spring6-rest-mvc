package com.darc.springrestmvc.mappers;

import com.darc.springrestmvc.entities.Beer;
import com.darc.springrestmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
