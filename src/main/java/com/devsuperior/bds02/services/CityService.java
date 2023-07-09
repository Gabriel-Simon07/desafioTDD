package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public CityDTO insert(CityDTO city) {
        City cityEntity = new City();
        cityEntity.setName(city.getName());
        cityEntity = cityRepository.save(cityEntity);
        return new CityDTO(cityEntity);
    }
}
