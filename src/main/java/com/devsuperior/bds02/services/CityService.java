package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.BadRequestException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void delete(Long id) {
        try {
            cityRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Bad request");
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

//    @Transactional
//    public void delete(Long id) {
//        try {
//            cityRepository.deleteById(id);
//        } catch (EmptyResultDataAccessException e) {
//            throw new ResourceNotFoundException("Id not found " + id);
//        } catch (DataIntegrityViolationException e) {
//            throw new DataBaseException("Integrity violation");
//        } catch (ConstraintViolationException e) {
//            throw new BadRequestException("Resource bad request");
//        }
//    }
}
