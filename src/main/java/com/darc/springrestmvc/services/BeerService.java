package com.darc.springrestmvc.services;

import com.darc.springrestmvc.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
